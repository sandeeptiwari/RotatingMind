package com.rotatingmind.array.hashmap;

import java.util.HashMap;
import java.util.Map;

public class TotalCharactersInStringAfterTransformationsFirst3335 {
    private static final int MOD = 1000000007;

    public int lengthAfterTransformations(String s, int t) {
        Map<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            result.compute(s.charAt(i), (k, v) -> v != null ? ++v : 1);
        }

        for (int i = 0; i < t; i++) {
            result = transform(result);
        }

        var res = result.values().stream().mapToInt(Integer::intValue).sum();

        return res % MOD;
    }

    private Map<Character, Integer> transform(Map<Character, Integer> base) {
        Map<Character, Integer> result = new HashMap<>();

        for (var key: base.keySet()) {
            if (key == 'z') {
                
                var v = base.getOrDefault('a', 0);
                var v1 = base.getOrDefault('b', 0);
                result.put('a', ++v);
                result.put('b', ++v1);
            } else {
                int updatedCh = (int)key + 1;
                char chs = (char)updatedCh;
                var oldFreq = base.getOrDefault(key, 0);
                var newFreq = result.getOrDefault(chs, 0);
                result.put(chs, oldFreq + newFreq);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TotalCharactersInStringAfterTransformationsFirst3335 obj = new TotalCharactersInStringAfterTransformationsFirst3335();
        //System.out.println("Result " +  obj.lengthAfterTransformations("jqktcurgdvlibczdsvnsg", 7517));
        System.out.println("Result " +  obj.lengthAfterTransformations("abcyy", 2));
    }

}
