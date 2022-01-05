package com.rotatingmind.jukebox.model;

import java.util.Set;

public class CDPlayer {
    private CD cd;
    private final Set<CD> cds;
    private final Playlist playlist;

    public CDPlayer(Set<CD> cds, Playlist playlist) {
        this.cds = cds;
        this.playlist = playlist;
    }

    public void playNextSong() {}

    public void playPreviousSong() {}

    public void addCD(CD cd) {
        cds.add(cd);
    }

    public void removeCD(CD cd) {
        cds.remove(cd);
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public CD getCd() {
        return cd;
    }

    public Set<CD> getCds() {
        return cds;
    }
}
