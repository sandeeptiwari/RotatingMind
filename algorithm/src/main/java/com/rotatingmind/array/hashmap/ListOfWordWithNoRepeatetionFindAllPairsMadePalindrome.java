package com.rotatingmind.array.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

record Pair(int i, int j) {}

/**
 * Given a list of words, all are unique, find all pair of indices (i, j) s.t.
 * words[i] + words[j] = palindrome
 *
 * e.g. [xyz, p, zyx, ssp, pppss]
 *
 * Property of Palindrome:: if prefix of string is palindrome a=then reverse prefix must be available in same string
 * and sandwich part would be independent palindrome
 *
 * Note: consider empty string as well
 *
 * e.g. abc dmpmd cba
 *
 * we need to same check for both prefix and suffix and string would be palindrome if
 *  word: reverse(0..i) to be present in words array
 *   AND isPalindrome(i+1..N-1) sandwich part
 *
 *  Edge case:
 *   1- empty prefix/suffix string
 *   2- aaa reverse of this again aaa which is available in map so we need to handle it
 *   3- duplicate pair (p,q) & again (p, q)
 *    ---ab-----ba--- => for both prefix and suffix will get duplicate pair
 *    i- prefix of ab and suffix of ab (i, j) & (j, i)
 *    ii- prefix and suffix of ba (j,i< (i, j) which lead to duplicate
 *    Store pair into map to track duplicate pair
 */
public class ListOfWordWithNoRepeatetionFindAllPairsMadePalindrome {


    public static List<List<Integer>> getAllPairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Map<Pair, Boolean> m = new HashMap<>();
        List<List<Integer>> pairs = new ArrayList<>();
        int len = words.length;

        for (int i = 0; i < len; i++) {
            String key = reverse(words[i]);
            map.put(key, i);
        }

        for (int i = 0; i < len; i++) {
            String word = words[i];

            if (map.containsKey("") && map.get("") != i && isPalindrome(word) && !m.containsKey("")) {
                Pair p1 = new Pair(i, map.get(""));
                Pair p2 = new Pair(map.get(""), i);
                m.put(p1, true);
                m.put(p2, true);
                pairs.add(List.of(i, map.get("")));
                pairs.add(List.of(map.get(""), i));
            }



            int n = word.length();

            //For prefix
            for (int j = 0; j < n; j++) {
                String prefix = word.substring(0, j + 1);
                if (map.containsKey(prefix) &&
                        map.get(prefix) != i &&
                        isPalindrome(word.substring(prefix.length())) &&
                        !m.containsKey(new Pair(i, map.get(prefix)))) {
                    Pair p = new Pair(i, map.get(prefix));
                    m.put(p, true);
                    pairs.add(List.of(i, map.get(prefix)));
                }


            }

            //For suffix
            for (int j = n - 1; j >= 0; j--) {
                String suffix = word.substring(j);
                if (map.containsKey(suffix) &&
                        map.get(suffix) != i &&
                        isPalindrome(word.substring(0, j)) &&
                        !m.containsKey(new Pair(map.get(suffix), i))) {
                    Pair p = new Pair(map.get(suffix), i);
                    m.put(p, true);
                    pairs.add(List.of(map.get(suffix), i));
                }
            }
        }

        return pairs;
    }

    public static boolean isPalindrome(String str) {
        char[] chs = str.toCharArray();
        int i = 0;
        int j = chs.length - 1;

        while (i < j) {
            if (chs[i] != chs[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static String reverse(String str) {

        char[] chs = str.toCharArray();
        int i = 0;
        int j = chs.length -1;

        while(i < j) {
            char tmp = chs[i];
            chs[i] = chs[j];
            chs[j] = tmp;
            i++;
            j--;
        }
        return new String(chs);
    }


    public static void main(String[] args) {
        // String[] str = {"abcd","dcba","lls","s","sssll"};
        String[] str = {"a","abc","aba",""};
        System.out.println(getAllPairs(str));
    }
}
