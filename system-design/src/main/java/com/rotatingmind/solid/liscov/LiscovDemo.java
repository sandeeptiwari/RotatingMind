package com.rotatingmind.solid.liscov;

import java.util.List;

public class LiscovDemo {

    public static void main(String[] args) {

        List<Member> members = List.of(
                new PremiumMember("Jack Hores"),
                new VipMember("Tom Jhon"),
                new FreeMember("Martin Vilop")
        );

       /* List<TournamentOrganizer> members = List.of(
                new PremiumMember("Jack Hores"),
                new VipMember("Tom Jhon"),
                new FreeMember("Martin Vilop")
        );*/

       //members.forEach(Member::organizeTournament);// This is showstopper, broke the Liscove'e

       /* members.forEach( member -> {
            if (member instanceof Member) {
                ((Member) member).organizeTournament();
            } else {
                member.joinTournament();
            }
        });*/
    }
}
