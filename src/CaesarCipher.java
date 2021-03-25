import java.util.HashMap;
import java.util.Map;

public class CaesarCipher {

    public static void main(String...args){
        System.out.println(caesarCipher("middle-Outz", 2));
    }

    static String caesarCipher(String s, int k) {
        Map<Integer, Integer> alphbetMap = new HashMap<>();
        for (int j = 0, i = 97; i < 123; j++, i++) {
            alphbetMap.put(i, j);
        }

        for (int j = 0, i = 65; i < 91; j++, i++) {
            alphbetMap.put(i, j);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int value = 97;
            if (Character.isAlphabetic((int) ch)) {
                if (Character.isLowerCase(ch))
                    value = 97 + (alphbetMap.get((int) ch) + k) % 26;
                else if (Character.isUpperCase(ch))
                    value = 65 + (alphbetMap.get((int) ch) + k) % 26;
                builder.append((char) value);
            } else
                builder.append(ch);
        }
        return builder.toString();
    }


}
