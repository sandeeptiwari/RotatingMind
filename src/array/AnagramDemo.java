package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AnagramDemo {

    public static void main(String[] args) {
        AnagramDemo anagram = new AnagramDemo();
        System.out.println(" Anagram " + anagram.isAnagram("restfull", "lluftser"));
    }

    public boolean isAnagram(String firstWord, String secondWord) {
        if (firstWord.length() != secondWord.length()) {
            return false;
        }
        var secondChars = secondWord.toCharArray();

        /*var chars = firstWord.codePoints().mapToObj(Character::toString).toArray();
        var charCountMap
                = Arrays.stream(chars).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));*/

        Map<String, Long> charCountMap = IntStream.range(0, firstWord.length())
                .mapToObj(i -> firstWord.substring(i, i + 1))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (int index = 0; index < secondChars.length; index ++) {
            String key = "" + secondChars[index];
            long count = charCountMap.getOrDefault(key, 0l);
            count = count - 1;
            if (count != 0) {
                charCountMap.put(key, count);
            } else {
                charCountMap.remove(key);
            }
        }
        return charCountMap.size() == 0;
    }
}
