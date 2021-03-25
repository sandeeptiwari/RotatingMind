package ocjp;

import java.io.Console;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

public class ListDemo {

    public static void main(String...args){
        List<Integer> source = Arrays.asList(5, 10);
        //ListDemo.magic(Stream.empty());//source.stream());
        /*List<Integer> fish = new CopyOnWriteArrayList<>();
        List<Integer> mammals = Collections.synchronizedList(source);
        Set<Integer> birds = new ConcurrentSkipListSet<>();
        birds.addAll(source);
        synchronized (new Integer(10)){
            for(Integer f: fish) fish.add(4);
            for(Integer f: fish) fish.add(4);
            for(Integer f: fish) fish.add(4);
        }*/

        /*String line = "";
        Console c = System.console();
        if((line = c.readLine()) != null){
            System.out.println(line);
        }*/

        try(Scanner scanner = new Scanner("rain");){ //String line = "";
            if(scanner.nextLine().equals("rain")){
                throw new RuntimeException();
            }
        }finally {
            //scanner.close();
        }
    }

    public static void magic(Stream<Integer> s){
        Optional o = s.filter(x -> x > 5).limit(3).max(Comparator.comparingInt(x -> x));
        System.out.println(o.get());
    }
}
