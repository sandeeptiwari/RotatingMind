package com.sandi.test.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WeightedUniformString {

    public static void main(String...args){

        int[] queries = {9,7,8,12,5};//{1, 3, 12, 5, 9, 10};

        String[] result = weightedUniformStringsV2("aaabbbbcccddd", queries);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
//abccddde // aaabbbbcccddd
    public static String[] weightedUniformStringsV1(String s, int[] queries){
        Map<String, Integer> alphabetMaps = new HashMap<>();
        Map<Integer, String> keyWithQueriesMap = new HashMap<>();

        for (int index = 97; index < 123; index++) {
            alphabetMaps.put(""+((char)index), (index - 96));
        }

        String key = "";
        for (int i = 0, j = 0; i < s.length();) {
             char ch = s.charAt(j);

             if(ch == s.charAt(i)){
                 key +=ch;
                 keyWithQueriesMap.put(alphabetMaps.get(""+ch)*key.length(), key);
                 i++;
             }else{
                 j = i;
                 key = "";
             }

        }

        String[] result = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int v = queries[i];
            if(keyWithQueriesMap.get(v) != null){
                result[i] = "YES";
            }else{
                result[i] = "NO";
            }
        }
        return result;
    }


    public static String[] weightedUniformStringsV2(String s, int[] queries){
        int continuousString = 1;
        int lastAlphaNumber = 0;
        int currentAlphNumber = 0;
        Set<Integer> queriesSet = new HashSet<>();

        for (int index = 0; index < s.length(); index++) {
            currentAlphNumber = s.charAt(index) - 'a' + 1;

            if(lastAlphaNumber == currentAlphNumber){
                continuousString++;
            }else {
                lastAlphaNumber = currentAlphNumber;
                continuousString = 1;
            }

            queriesSet.add(currentAlphNumber * continuousString);
        }

        String[] result = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int v = queries[i];
            if(queriesSet.contains(v)){
                result[i] = "YES";
            }else{
                result[i] = "NO";
            }
        }
        return result;
    }

}
