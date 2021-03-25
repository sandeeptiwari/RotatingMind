import java.util.HashSet;
import java.util.Set;

public class Testpangram {

    static String pangrams(String s) {
        int len = s.length();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i< len; i++){
            char ch = s.toLowerCase().charAt(i);
            if(Character.isAlphabetic(ch))
             set.add(ch);
        }
        return set.size() == 26 ? "pangram" : "not pangram";
    }



    public static void main(String...args){
       // System.out.print(pangrams("We promptly judged antique ivory buckles for the next prize"));
        separateNumbers("91011");
    }

    static void separateNumbers(String s) {

        long shor=0;
        if(s.length()==1){
            System.out.println("NO");

        }
        for(int i=1;i<=(s.length()/2);i++){
            if(s.charAt(0)==0){
                System.out.println("NO");
                break;
            }
            long sub = Long.parseLong(s.substring(0,i));
            String p ="";
            p+=sub;
            shor = sub;
            long len = String.valueOf(shor).length();
            for(int j=0;j<s.length();j++){
                sub++;
                p+=sub;
            }
            String d = p.substring(0,s.length());
            if(d.equals(s.substring(0,s.length())) && (d.length()%len==0 || d.length()%len==1)){
                System.out.println("YES" +" "+shor);
                break;
            }
            if(i==s.length()/2){
                System.out.println("NO");
            }

        }
    }
}
