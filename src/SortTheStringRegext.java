import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SortTheStringRegext {

    private List<String> sort(List<String> strList){
        String regex = "^[A-Z][a-z]*\\.$";
        Pattern pattern = Pattern.compile(regex);
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if ( s1 == null && s2 == null ) {
                    return 0;
                } else if ( s1 != null && s2 == null ) {
                    return -1;
                } else if ( s1 == null && s2 != null ) {
                    return 1;
                } else {
                    Matcher s1Matcher = pattern.matcher( s1 );
                    Matcher s2Matcher = pattern.matcher( s2 );

                    if ( !s1Matcher.matches() && !s2Matcher.matches() ) {
                        return s1.compareTo( s2 );
                    } else if ( s1Matcher.matches() && !s2Matcher.matches() ) {
                        return -1;
                    } else if ( !s1Matcher.matches() && s2Matcher.matches() ) {
                        return 1;
                    } else {
                        int i1 = Integer.parseInt( s1Matcher.group( 1 ) );
                        int i2 = Integer.parseInt( s2Matcher.group( 1 ) );
                        return i1 - i2;
                    }
                }
            }
        };

         return strList.stream().sorted().sorted(cmp).collect(Collectors.toList());
    }


    public static void main(String...args){
        SortTheStringRegext sortTheStringRegext = new SortTheStringRegext();

        sortTheStringRegext.sort(Arrays.asList("Ram ", "Aaam ", "Jaadooo ")).forEach(System.out::print);
    }
}
