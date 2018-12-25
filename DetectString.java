import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DetectString {
    //hackerrank
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String...args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();
            String result = hackerrankInString(s);
            System.out.print(result);
        }

        scanner.close();
    }

    //hhaacckkekraraannk
    public static String hackerrankInString(String s) {
        String target = "hackerrank";
        int hackerRRankLen = target.length();
        int inputLen = s.length();
        int arr[] = new int[hackerRRankLen];
        int j = 0;
        if(hackerRRankLen > inputLen)
            return "NO";

        for (int i = 0; i < inputLen; i++) {
            if(j == hackerRRankLen)
                break;

            char ch = s.charAt(i);
            if(ch == target.charAt(j)){
               j++;

            }
        }
        return j == hackerRRankLen ? "YES" : "NO";
    }
}
