package screencord;

import javax.sound.sampled.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.jcodec.api.awt.AWTSequenceEncoder;
public class MeetingRecorder {
        private int frameRate;
        private int duration;
        private String outputFilePath;

        private TargetDataLine audioLine;
        private AWTSequenceEncoder encoder;

        public MeetingRecorder(int frameRate, int duration, String outputFilePath) {
            this.frameRate = frameRate;
            this.duration = duration;
            this.outputFilePath = outputFilePath;
        }

        public void startRecording() throws AWTException, IOException, LineUnavailableException {
            // Get the screen size
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

            // Create a new robot instance
            Robot robot = new Robot();

            // Create a new sequence encoder
            encoder = AWTSequenceEncoder.createSequenceEncoder(new File(outputFilePath), frameRate);

            // Get the mixer for the system audio
            Mixer mixer = AudioSystem.getMixer(null);

            // Create an audio format
            AudioFormat audioFormat = new AudioFormat(44100, 16, 2, true, true);

            // Get the target data line for the audio
            DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, audioFormat);
            audioLine = (TargetDataLine) mixer.getLine(dataLineInfo);

            // Open the audio line
            audioLine.open(audioFormat);
            audioLine.start();

            // Create a new thread pool
            ExecutorService threadPool = Executors.newFixedThreadPool(2);

            // Get the start time in milliseconds
            long startTime = System.currentTimeMillis();

            // Loop until the duration is reached
            while (System.currentTimeMillis() - startTime <= duration * 1000) {
                // Capture the screen
                BufferedImage image = robot.createScreenCapture(screenRect);

                // Submit the image encoding task to the thread pool
                threadPool.submit(() -> {
                    try {
                        // Encode and write the frame to the video file
                        encoder.encodeImage(image);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                // Read the audio data
                byte[] audioData = new byte[audioLine.getBufferSize() / 5];
                int bytesRead = audioLine.read(audioData, 0, audioData.length);

                // Submit the audio encoding task to the thread pool
                /*threadPool.submit(() -> {
                    try {
                        // Write the audio data to the encoder
                        encoder.encodeImage(0, audioData, 0, bytesRead, new Date().getTime());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });*/

                // Wait for the next frame
                try {
                    Thread.sleep(1000 / frameRate);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Finalize the encoding
            encoder.finish();

            // Shutdown the thread pool
            threadPool.shutdownNow();

            // Stop and close the audio line
            audioLine.stop();
            audioLine.close();
        }

}
