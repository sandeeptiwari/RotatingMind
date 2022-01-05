package com.rotatingmind.jukebox;

import com.rotatingmind.jukebox.model.CDPlayer;
import com.rotatingmind.jukebox.model.Selector;
import com.rotatingmind.jukebox.model.Song;

public class JukeBox implements Selector {
    private final CDPlayer cdPlayer;

    public JukeBox(CDPlayer cdPlayer) {
        this.cdPlayer = cdPlayer;
    }

    public void nextSongBtn() {}

    public void previousSongBtn() {}

    public void addSongToPlaylistBtn(Song son) {}

    public void removeSongFromPlaylistBtn(Song song) {}

    public void shuffle() {}
}
