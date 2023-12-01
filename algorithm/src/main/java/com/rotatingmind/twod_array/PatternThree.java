package com.rotatingmind.twod_array;

public class PatternThree {
    String serbianString = "Šta radiš?"; // What are you doing?
    String germanString = "Wie heißen Sie?"; // What's your name?
    String japaneseString = "よろしくお願いします"; // Pleased to meet you.

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                if ((i + j)  % 2 == 0) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println("");
        }
    }

}
