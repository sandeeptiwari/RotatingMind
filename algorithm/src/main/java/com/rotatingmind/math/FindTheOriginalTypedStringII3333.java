package com.rotatingmind.math;

public class FindTheOriginalTypedStringII3333 {

    private static final int MOD = 1_000_000_007;

    public int possibleStringCount(String word, int k) {
        int n = word.length();
        int count = 0;

        if (n == k) return 1;

        for (int i = 1; i < n; i++) {

            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            }
        }

        int needToSelect = count - k;
        int totalPossibleChars = n - count;

        long nFact = fact(totalPossibleChars); // 5! = 120
        long rFact = fact(needToSelect);       // 2! = 2
        long nMinusRFact = fact(totalPossibleChars - needToSelect); // 3! = 6

        // denominator = r! * (n - r)!
        long denominator = (rFact * nMinusRFact) % MOD;
        // Modular inverse of denominator
        long denominatorInverse = modInverse(denominator, MOD);

        // result = n! * inverse of denominator
        long result = (nFact * denominatorInverse) % MOD;

        return (int)result + 1;
    }

    private long fact(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = (result * i) % MOD;
        }
        return result;
    }

    // Fermat's Little Theorem: a^(MOD - 2) % MOD
    private long modInverse(long a, int mod) {
        return modPow(a, mod - 2, mod);
    }

    private long modPow(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        FindTheOriginalTypedStringII3333 obj = new FindTheOriginalTypedStringII3333();
        String word = "aaabbb";
        int k = 3;
        System.out.println(obj.possibleStringCount(word, k));
    }
}
