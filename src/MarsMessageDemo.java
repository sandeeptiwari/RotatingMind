import java.util.stream.Stream;

public class MarsMessageDemo {
    //SOS
    public static void main(String...args){
        System.out.println(marsExploration("SOSOOSOSOSOSOSSOSOSOSOSOSOS"));
    }

    public static int marsExploration(String message){
        String sos = "SOS";
        int count = 0;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) != sos.charAt(i % 3)) count++;
        }
        return count;
    }
}
