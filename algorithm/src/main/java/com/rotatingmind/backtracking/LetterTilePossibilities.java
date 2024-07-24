package com.rotatingmind.backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * You have n  tiles, where each tile has one letter tiles[i] printed on it.
 *
 * Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.
 *
 * Example 1:
 *
 * Input: tiles = "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 * Example 2:
 *
 * Input: tiles = "AAABBC"
 * Output: 188
 * Example 3:
 *
 * Input: tiles = "V"
 * Output: 1
 */
public class LetterTilePossibilities {


    public static int numTilePossibilities(String tiles) {
        int n = tiles.length();
        Set<String> result = new HashSet<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        String s = "";
        solve(tiles, s, visited, result);
        return result.size();
    }


    public static void solve(String tiles, String s, Map<Integer, Boolean> visited, Set<String> result) {
        int n = tiles.length();

        for (int i = 0; i < n; i++) {

            if (!visited.getOrDefault(i, false)) {
                s += tiles.charAt(i);
                visited.put(i, true);
                result.add(s);
                solve(tiles, s, visited, result);
                s = s.substring(0, s.length() - 1);
                visited.put(i, false);
            }

        }
    }

    /*public static int numTilePossibilities(String tiles) {
        int n = tiles.length();
        Set<String> tilesStr = new HashSet<>();

        for (int i = 0; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                String currStr = tiles.substring(i, j);
                if(currStr.length() > 0) {
                    tilesStr.add(currStr);
                }
            }
        }

        Set<String> result = new HashSet<>();

        for (String s : tilesStr) {
            numTilePossibilities(s, 0, result);
        }
        return result.size();
    }
*/
    public static void numTilePossibilities(String tiles, int i, Set<String> result) {
        int n = tiles.length();

        if (i == n) {
            result.add(tiles);
        }

        for (int j = i; j < n; j++) {
            tiles = swap(tiles, i, j);
            numTilePossibilities(tiles, i + 1, result);
            tiles = swap(tiles, i, j);
        }

    }

    public static String swap(String s, int i, int j) {
        char[] chs = s.toCharArray();
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
        return new String(chs);
    }

    public static void main(String[] args) {
       //String tiles = "AAABBC";
        String tiles = "AAB";
        int count = numTilePossibilities(tiles);
        System.out.println(count);
    }
}
