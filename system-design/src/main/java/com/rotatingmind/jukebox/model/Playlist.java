package com.rotatingmind.jukebox.model;

import java.util.Collections;
import java.util.List;

public class Playlist {
    private Song song;
    private List<Song> songs;

    public Playlist(Song song, List<Song> songs) {
        this.song = song;
        this.songs = songs;
    }

    public Playlist(List<Song> songs) {
        this.songs = songs;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(Song song) {
        songs.removeIf(sng -> sng.getTitle().equals(song.getTitle()));
    }

    public void shuffle() {
        Collections.shuffle(songs);
    }

    public Song getNextSong() {
        return null;
    }

    public Song getPrevSong() {
        return null;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
