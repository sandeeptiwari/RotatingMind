package com.rotatingmind.jukebox.model;

import com.rotatingmind.jukebox.JukeBox;

public class User {

    private final JukeBox jukeBox;

    public User(JukeBox jukeBox) {
        this.jukeBox = jukeBox;
    }

    public JukeBox play() {
        return jukeBox;
    }

    public static void main(String[] args) {
        Song song = new Song("Mangal Bhavan a Mangal", null);
        CD cd = new CD(song);
        CDPlayer cdPlayer = new CDPlayer(null, null);
        User user = new User(new JukeBox(cdPlayer));
    }


}
