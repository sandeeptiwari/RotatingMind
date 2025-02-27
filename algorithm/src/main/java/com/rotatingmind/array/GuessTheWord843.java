package com.rotatingmind.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

interface Master {
  int guess(String word);
}

public class GuessTheWord843 {

    public void findSecretWord(String[] words, Master master) {

        List<String> candidates = new ArrayList<>(Arrays.asList(words));
        int attempts = 10;

        while(attempts-- > 0) {
            // Step 1: Pick a random word from candidates
            String guessWord = candidates.get(new Random().nextInt(candidates.size()));
            // Step 2: Get feedback from master
            int matches = master.guess(guessWord);

            if (matches == 6) {
                System.out.println("You guessed the secret word correctly.");
                return;
            }

            candidates = candidates.stream().filter(word -> matchCounts(word, guessWord) != matches).toList();
        }
        System.out.println("Either you took too many guesses, or you did not find the secret word.");
    }

    private int matchCounts(String word1, String word2) {
        int n = word1.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        String[] wordlist = {"acckzz", "ccbazz", "eiowzz", "abcczz", "abcxyz"};
        String secret = "acckzz";  // Hidden word

        // Master implementation to simulate feedback
        Master master = word -> {
            int count = 0;
            for (int i = 0; i < secret.length(); i++) {
                if (word.charAt(i) == secret.charAt(i)) {
                    count++;
                }
            }
            System.out.println("Guess: " + word + " → Matches: " + count);
            return count;
        };

        new GuessTheWord843().findSecretWord(wordlist, master);
    }
}
