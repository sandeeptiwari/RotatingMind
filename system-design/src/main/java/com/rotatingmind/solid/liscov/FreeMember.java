package com.rotatingmind.solid.liscov;

public class FreeMember implements TournamentJoiner {//extends Member {
    private final String name;

    public FreeMember(String name) {
        this.name = name;
    }
/*
    public FreeMember(String name) {
        super(name);
    }*/

    @Override
    public void joinTournament() {
        System.out.println("Free member joins tournaments");
    }
/*
    @Override
    public void organizeTournament() {
        System.out.println("Free member can't organize tournaments");
    }*/
}
