package com.rottaingmind.ds.dp.word_conversion;

public class EditDistance {

    private int getEditDistance(String word1, String word2) {
        if (word1.isEmpty() || word2.isEmpty()) {
            return 0;
        }
        int[][] ans = new int[word1.length() + 1][word2.length() + 1];

        for (int j = 0; j <= word2.length(); j++) {
            ans[0][j] = j;
        }

        for (int i = 0; i <= word1.length(); i++) {
            ans[i][0] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    ans[i][j] = ans[i - 1][j - 1];
                } else {
                    ans[i][j] = Math.min(ans[i - 1][j - 1], Math.min(ans[i][j - 1], ans[i - 1][j]));
                }
            }

        }
        return ans[word1.length()][word2.length()];
    }
}
