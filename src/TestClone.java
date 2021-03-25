import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestClone {

    public static void main(String...args) throws CloneNotSupportedException {
        /*Book b = new Book(100l, "123455", "Hello Java", 1321);
        Book book  = (Book) b.clone();
        book.setIsbn("090909");

        System.out.print(book);
        */

        System.out.print(gemstones(new String[]{"basdfj", "asdlkjfdjsa", "bnafvfnsd", "oafhdlasd"})); //4
    }

    static int gemstones(String[] arr) {
        List<String> list = Stream.of(arr).sorted().collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        int longestLen = list.get(list.size() - 1).length();
        int count = 0;
        for(int i = 0; i < longestLen; i++){
            char ch = list.get(list.size() - 1).charAt(i);
            for (int j = 0; j < list.size() - 1 ; j++) {
                String str = list.get(j);
                if(str.contains(""+ch)){
                   count++;
                }
            }
            if((count == list.size() - 1) && !builder.toString().contains(""+ch)){
                builder.append(ch);
            }
            count = 0;
        }
      return builder.length();

    }

}
