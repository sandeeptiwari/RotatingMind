package string_ops;

public class ReverseString {


    public String reverseString(String str) {
        char[] charArray = str.toCharArray();
        int len = charArray.length;

        for (int i = 0, j = len - 1 ; i < j; i++, j--) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }

        return new String(charArray);
    }

    public String reverseStringV1(String str) {
        char[] charArray = str.toCharArray();
        int len = charArray.length;

        for (int i = 0, j = len - 1 ; i < j; i++, j--) {
            charArray[i] ^= charArray[j];
            charArray[j] ^= charArray[i];
            charArray[i] ^= charArray[j];
        }

        return new String(charArray);
    }

    public String reverseStringAtPlace(String str) {
        String[] words = str.split(" ");
        int len = words.length;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append(reverseString(words[i]));
            builder.append(" ");
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        String str = "Hello World";
        System.out.println(rs.reverseStringAtPlace(str));
    }
}
