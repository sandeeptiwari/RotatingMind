package com.rotatingmind.jukebox.model;

public interface Selector {
    void nextSongBtn();

    void previousSongBtn();

    void addSongToPlaylistBtn(Song son);

    void removeSongFromPlaylistBtn(Song song);

    void shuffle();
}
