package char_encoding;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class UTFEightEncoding {

    String serbianString = "Šta radiš?"; // What are you doing?
    String germanString = "Wie heißen Sie?"; // What's your name?
    String japaneseString = "よろしくお願いします"; // Pleased to meet you.


    public void testEncoding() {
        String asciiSerbianString = new String(serbianString.getBytes(), StandardCharsets.US_ASCII);
        String asciigermanString = new String(germanString.getBytes(), StandardCharsets.US_ASCII);
        String asciijapaneseString = new String(japaneseString.getBytes(), StandardCharsets.US_ASCII);

        System.out.println(asciiSerbianString);
        System.out.println(asciigermanString);
        System.out.println(asciijapaneseString);
    }

    public void testEncodingV1() {
        String asciiSerbianString = new String(serbianString.getBytes(), StandardCharsets.UTF_8);

        System.out.println(asciiSerbianString);
    }

    public void testEncodingV3() {
        String japaneseString = "よろしくお願いします"; // Pleased to meet you.

       // ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(japaneseString);

        //String utf8String = new String(byteBuffer.array(), StandardCharsets.UTF_8);
        String utf8String = new String(japaneseString.getBytes(), StandardCharsets.UTF_8);
        System.out.println(utf8String);
    }

    public static void main(String[] args) {
        UTFEightEncoding utfEightEncoding = new UTFEightEncoding();
        utfEightEncoding.testEncodingV3();
    }
}
