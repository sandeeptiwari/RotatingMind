package com.rotatingmind.recursion;

public class CountOfMatchesInTournament {

    public int numberOfMatches(int n) {
        return totalMatches(n);
    }


    public int totalMatches(int n) {
        if (n == 1) return 1;

        if (n % 2 == 0) {
            int v1 =  (n / 2) + totalMatches(n / 2);
            return v1;
        } else {
            int v2 = ((n - 1) / 2) + totalMatches(((n - 1) / 2) + 1);
            return v2;
        }
    }

    public static void main(String[] args) {
        CountOfMatchesInTournament obj = new CountOfMatchesInTournament();
        System.out.println(obj.numberOfMatches(7));
    }
}
