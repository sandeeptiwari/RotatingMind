import java.util.HashSet;
import java.util.Set;
 
/**
 * Java Program to find all permutations of a String
 * @author pankaj
 *
 */
public class StringHelper {
    public static Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<String>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
		System.out.println("initial "+initial);
        String rem = str.substring(1); // Full string without first character
		System.out.println("rem "+rem);
        Set<String> words = permutationFinder(rem);
		System.out.println("words "+words);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
				String addStr = charInsert(strNew, initial, i);
				System.out.println("add "+addStr);
                perm.add(addStr);
            }
        }
		System.out.println("for end "+perm.size());
        return perm;
    }
 
    public static String charInsert(String str, char c, int j) {
		System.out.println("strNew "+str+" initial char "+c+" pos "+ j);
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }
 
    public static void main(String[] args) {
        //String s = "AAC";
        String s1 = "ABC";
        //String s2 = "ABCD";
        //System.out.println("\nPermutations for " + s + " are: \n" + permutationFinder(s));
        System.out.println("\nPermutations for " + s1 + " are: \n" + permutationFinder(s1));
        //System.out.println("\nPermutations for " + s2 + " are: \n" + permutationFinder(s2));
    }
}

package Strings;

public class PermitationString {
public static void main(String[] args) {
String s = “ABC”;
permutation(s);
}
public static void permutation(String str) {
permutation(“”, str);
}

private static void permutation(String prefix, String str) {
int n = str.length();
if (n == 0)
System.out.println(prefix);
else {
for (int i = 0; i < n; i++)
permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
}
}
}