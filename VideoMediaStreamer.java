package com.gopro.buckhorn.utils;


import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class VideoMediaStreamer {
    private static final String TAG = VideoMediaStreamer.class.getSimpleName();
    private static final int INTIAL_KB_BUFFER = 96 * 10 / 8;
    private static VideoMediaStreamer instance;
    private Context context;
    private MediaStreamerListener listener;
    private Handler handler;
    private long totalKbRead;
    private File downloadingMediaFile;
    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnPreparedListener preparedListenr;
    private MediaPlayer.OnCompletionListener completionListener;
    private SurfaceTexture mSurfaceTexture;

    private VideoMediaStreamer(Context context, SurfaceTexture surfaceTexture) {
        this.context = context;
        mSurfaceTexture = surfaceTexture;
        handler = new Handler();
    }

    public synchronized static VideoMediaStreamer getInstance(Context context, SurfaceTexture surfaceTexture) {
        if (instance == null)
            instance = new VideoMediaStreamer(context, surfaceTexture);

        return instance;
    }

    public void setListener(MediaStreamerListener listener) {
        this.listener = listener;
    }

    public void setPreparedListenr(MediaPlayer.OnPreparedListener preparedListenr) {
        this.preparedListenr = preparedListenr;
    }

    public void setCompleteListener(MediaPlayer.OnCompletionListener completionListener) {
        this.completionListener = completionListener;
    }


    public void startStreaming(final String mediaUrl) throws IOException {

        Runnable r = new Runnable() {
            public void run() {
                try {
                    Log.i(TAG, " ACTUAL FILE PATH "+mediaUrl);
                    downloadVideoIncrement(mediaUrl);
                } catch (IOException e) {
                    Log.e(getClass().getName(), "Initialization error for fileUrl=" + mediaUrl, e);
                    return;
                }
            }
        };
        new Thread(r).start();
    }

    private void downloadVideoIncrement(String mediaUrl) throws IOException {
        // First establish connection to the media provider
        URLConnection cn = new URL(mediaUrl).openConnection();
        cn.connect();
        InputStream stream = cn.getInputStream();
        if (stream == null) {
            Log.e(TAG, "Unable to create InputStream for mediaUrl:" + mediaUrl);
        }
        // Create the temporary file for buffering data into
        downloadingMediaFile = File.createTempFile("downloadingMedia", ".lrv");
        FileOutputStream out = new FileOutputStream(downloadingMediaFile);
        // Start reading data from the URL stream
        byte buf[] = new byte[16384];
        int totalBytesRead = 0, incrementalBytesRead = 0;
        do {
            int numread = stream.read(buf);
            if (numread <= 0) {
                // Nothing left to read so quit
                Log.e(TAG, "MediaFile downloaded");
                break;
            } else {
                //Log.i(TAG, "reading video file "+totalBytesRead);
                out.write(buf, 0, numread);
                totalBytesRead += numread;
                incrementalBytesRead += numread;
                totalKbRead = totalBytesRead / 1000;
                // Test whether we need to transfer buffered data to the MediaPlayer
                testMediaBuffer();

                // Update the status for ProgressBar and TextFieldsfireDataLoadUpdate();
            }
        } while (true);
        // Lastly transfer fully loaded audio to the MediaPlayer and close the InputStream
        //listener.onDataFullyLoaded();
        stream.close();
    }


    private void testMediaBuffer() {
        // We’ll place our following code into a Runnable so the Handler can call it for running
        // on the main UI thread
        Runnable updater = new Runnable() {
            public void run() {
                if (mediaPlayer == null) {
                    // The MediaPlayer has not yet been created so see if we have
                    // the minimum buffered data yet.
                    // For our purposes, we take the minimum buffered requirement to be:
                    // INTIAL_KB_BUFFER = 96*10/8;//assume 96kbps*10secs/8bits per byte
                    Log.i(TAG, "TOTALKBREAD "+totalKbRead+" && KB "+INTIAL_KB_BUFFER);
                    if (totalKbRead >= INTIAL_KB_BUFFER) {
                        try {
                            // We have enough buffered content so start the MediaPlayer
                            Log.i(TAG, "Start Player");
                            startMediaPlayer(downloadingMediaFile);
                        } catch (Exception e) {
                            Log.e(getClass().getName(), "Error copying buffered conent.", e);
                        }
                    }
                } else if (mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition() <= 1000) {
                    // The MediaPlayer has been started and has reached the end of its buffered
                    // content. We test for < 1second of data (i.e. 1000ms) because the media
                    // player will often stop when there are still a few milliseconds of data left to play
                    transferBufferToMediaPlayer();
                }
            }
        };
        handler.post(updater);
    }

    private void startMediaPlayer(File bufferedFile) {
        Log.i(TAG, "File path "+bufferedFile.getAbsolutePath());
        try {
            File playingFile = File.createTempFile("playingMedia", ".lrv");
            FileUtils.copyFile(bufferedFile, playingFile);
            openVideo(playingFile.getAbsolutePath());
            //mediaPlayer.setDataSource();
           // mediaPlayer.prepare();
        } catch (IOException e) {
            //listener.onDataPreloadComplete();
            Log.e(TAG, "Error initializing the MediaPlaer.", e);
            return;
        }
    }

    private void transferBufferToMediaPlayer() {
        try {
            // Determine if we need to restart the player after transferring data (e.g. perhaps the user
            // pressed pause) & also store the current audio position so we can reset it later.
            boolean wasPlaying = mediaPlayer.isPlaying();
            int curPosition = mediaPlayer.getCurrentPosition();
            mediaPlayer.pause();
            // Copy the current buffer file as we can’t download content into the same file that
            // the MediaPlayer is reading from.
            File bufferedFile = File.createTempFile("playingMedia", ".lrv");
            FileUtils.copyFile(downloadingMediaFile, bufferedFile);
            // Create a new MediaPlayer. We’ve tried reusing them but that seems to result in
            // more system crashes than simply creating new ones.
           /* mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(bufferedFile.getAbsolutePath());
            mediaPlayer.prepare();*/
            openVideo(bufferedFile.getAbsolutePath());
            mediaPlayer.seekTo(curPosition);
            // Restart if at end of prior beuffered content or mediaPlayer was previously playing.
            // NOTE: We test for < 1second of data because the media player can stop when there is still
            // a few milliseconds of data left to play
            boolean atEndOfFile = mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition() <= 1000;
            if (wasPlaying || atEndOfFile) {
                mediaPlayer.start();
            }
        } catch (Exception e) {
            Log.e(TAG, "Error updating to newly loaded content.", e);
        }
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            Log.d(TAG, "VIDEO-PLAYER -> media release mediaPlayer ="+mediaPlayer);
             /* if(mMediaPlayer.isPlaying())*/
            try {
                mediaPlayer.stop();
                mediaPlayer.reset();
                mediaPlayer.release();
                mediaPlayer = null;
            }catch(Exception e){
                Log.e(TAG,"VIDEO-PLAYER ->Media Player stopped");
            }
            Log.d(TAG, "VIDEO-PLAYER ->Media Player Released");
        }
    }


    private void setMediaPlayerToIdleState(final boolean clearTargetState) {
        if (mediaPlayer != null) {
            //mCurrentState = STATE_IDLE;
            if (clearTargetState) {
                //mTargetState = STATE_IDLE;
            }
        }
    }


    private void openVideo(String uri) {
        /*if (mediaPlayer != null) {
            releaseMediaPlayer();
        }*/
        Log.i(TAG, "Playing file path "+"file:/"+uri );
        if (mSurfaceTexture != null) {
            mSurfaceTexture.updateTexImage();
        }
        mediaPlayer = new MediaPlayer();
        // we shouldn't clear the target state, because somebody might have called start() previously
        //setMediaPlayerToIdleState(false);
        try {


            //mMediaPlayer.setOnPreparedListener(mPreparedListener);
            //mMediaPlayer.setOnCompletionListener(mCompletionListener);
             mediaPlayer.setLooping(false);
            //if (isShowErrorMessage) {
            //    mediaPlayer.setOnErrorListener(mErrorListener);
           // }
            //mediaPlayer.setOnInfoListener(mInfoListener);
            //Log.d(TAG, "set data source =" + mUri);
            Uri myUri = Uri.parse(uri);
            Log.i(TAG, myUri.toString()+" File Name "+myUri.getEncodedPath());
            mediaPlayer.setDataSource("file:/"+uri);
            if(mSurfaceTexture!=null)
            {
                mediaPlayer.setSurface(new Surface(mSurfaceTexture));
                mediaPlayer.setScreenOnWhilePlaying(true);
            }
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

            mediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
                @Override
                public void onSeekComplete(MediaPlayer mp) {
                    Log.d(TAG, "Media Player Seeking Completed");
                    //onPlayStateListener.onSeekCompleted();
                }
            });
            mediaPlayer.prepare();

            // we don't set the target state here either, but preserve the target state that was there before.
           // mCurrentState = STATE_PREPARING;
        } catch (Exception ex) {
            Log.e(TAG, "Something went wrong"+ex);
            ex.printStackTrace();
        }
    }


    public interface MediaStreamerListener {

        void onDataPreloadComplete();

        void onDataFullyLoaded();
    }
}

