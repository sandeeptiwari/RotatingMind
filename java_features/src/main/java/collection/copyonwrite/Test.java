package collection.copyonwrite;

import org.apache.logging.log4j.spi.CopyOnWrite;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Iterator<String> it = list.iterator(); // cached the value ABC
        list.remove("A"); // will not change above iterator now it has remain ABC

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
