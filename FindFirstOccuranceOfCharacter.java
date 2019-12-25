package hashmap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//Find first non-recurring character in a string Input "Teeter" output r.
public class FindFirstOccuranceOfCharacter {

     public char findFirstOccOfNumber(String input) {
         char [] chars = input.toCharArray();
         Map<Character, CharCountContainer> map = new HashMap<>();

         for (int i = 0; i < chars.length; i++) {
             if (map.containsKey(chars[i])) {
                 CharCountContainer container = map.get(chars[i]);
                 container.setCount(container.getCount() + 1);
                 container.setIndex(i);
             } else {
                 CharCountContainer container =  new CharCountContainer();
                 container.setIndex(i);
                 container.setCount(1);
                 map.put(chars[i], container);
             }
         }

         Optional<Map.Entry<Character, CharCountContainer>> result =
                 map.entrySet().stream().filter(ele -> ele.getValue().getCount() == 1).
                         sorted(Comparator.comparingInt(ele -> (ele.getValue().getIndex()))).findFirst();

         return result.get().getKey();

     }

    public static void main(String...args) {
        FindFirstOccuranceOfCharacter findFirstOccuranceOfCharacter =
                new FindFirstOccuranceOfCharacter();
        System.out.println(findFirstOccuranceOfCharacter.findFirstOccOfNumber("geeksforgeeks"));
    }
}

class CharCountContainer {
    private int index;
    private int count;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
