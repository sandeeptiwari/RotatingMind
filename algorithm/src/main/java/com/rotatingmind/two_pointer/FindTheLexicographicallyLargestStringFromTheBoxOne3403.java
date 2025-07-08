package com.rotatingmind.two_pointer;

/**
 * You are given a string word, and an integer numFriends.
 *
 * Alice is organizing a game for her numFriends friends. There are multiple rounds in the game, where in each round:
 *
 * word is split into numFriends non-empty strings, such that no previous round has had the exact same split.
 * All the split words are put into a box.
 * Find the lexicographically largest string from the box after all the rounds are finished.
 *
 *
 *
 * Example 1:
 *
 * Input: word = "dbca", numFriends = 2
 *
 * Output: "dbc"
 *
 * Explanation:
 *
 * All possible splits are:
 *
 * "d" and "bca".
 * "db" and "ca".
 * "dbc" and "a".
 * Example 2:
 *
 * Input: word = "gggg", numFriends = 4
 *
 * Output: "g"
 *
 * Explanation:
 *
 * The only possible split is: "g", "g", "g", and "g".
 *
 *
 *
 * Constraints:
 *
 * 1 <= word.length <= 5 * 103
 * word consists only of lowercase English letters.
 * 1 <= numFriends <= word.length
 */
public class FindTheLexicographicallyLargestStringFromTheBoxOne3403 {

    //Find lexicographically largest substring of size n - numFriends + 1 or less starting at every index.
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int n = word.length();
        String answer = "";
        int longestPossible = n - (numFriends - 1); //3

        for (int i = 0; i < n; i++) {
            int endIndex = Math.min(longestPossible, n - i);

            String curStr = word.substring(i, i + endIndex);
            if (answer.compareTo(curStr) < 0) {
                answer = curStr;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        FindTheLexicographicallyLargestStringFromTheBoxOne3403 obj = new FindTheLexicographicallyLargestStringFromTheBoxOne3403();
        /*System.out.println(obj.answerString("dbca", 2));
        System.out.println(obj.answerString("gggg", 4));
        System.out.println(obj.answerString("gh", 1));
        System.out.println(obj.answerString("aann", 2));*/

        System.out.println("dbca".substring(0, 3));
        System.out.println("dbca".substring(1, 4));
        System.out.println("dbca".substring(2, 4));
        System.out.println("dbca".substring(3, 4));
    }
}
