
import java.util.ArrayList;
import java.util.List;

public class FunnyString {

    public static void checkStringFunnyOrNot(String input){
        boolean isFunny = false;
        List<Integer> diffs = new ArrayList<>();
        for (int i = 1; i < input.length(); i++) {
            char ch = input.charAt(i);
            char chNext = input.charAt(i - 1);
            diffs.add(ch - chNext);
        }
        int k = 0;

        input = new StringBuilder(input).reverse().toString();

        for (int i = 1; i < input.length(); i++) {
            char ch = input.charAt(i);
            char chNext = input.charAt(i - 1);

            int sec = chNext - ch;

            if( Math.abs(diffs.get(k)) == Math.abs(sec)){
                isFunny = true;
                k++;
                continue;
            }
            isFunny = false;
            break;
        }

        if(isFunny) {
            System.out.print("Funny");
            return;
        }

        System.out.print("Not Funny");
    }

    public static void findFunnyString(String s){
        boolean isFunny = false;
        for (int i = 0; i < Math.floor(s.length() / 2); i++) {
            char s1 = s.charAt(0);
            char s2 = s.charAt(i + 1);
            char r1 = s.charAt(s.length() - i - 1);
            char r2 = s.charAt(s.length() - i - 2);
            if (Math.abs(s1 - s2) == Math.abs(r1 - r2)) {
                isFunny = true;
                continue;
            }

            break;
        }
        if(isFunny) {
            System.out.print("Not Funny");
        }

        System.out.print(" Funny");

    }

    public static void main(String...args){
        //FunnyString.checkStringFunnyOrNot("ovyvzvptyvpvpxyztlrztsrztztqvrxtxuxq");
        FunnyString.findFunnyString("ovyvzvptyvpvpxyztlrztsrztztqvrxtxuxq");
    }
}
