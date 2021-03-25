package package1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void main(String... args) {
        /*List<Integer> l = new ArrayList();
        l.add("durga");
       // String s = l.get(0);
        System.out.println();*/
        /*List  <? super Child> list  =  new ArrayList<Parent1>( );

        List  <? extends Parent1> list1  =  new ArrayList<Child>( );*/

        ABC abc = new C();
        try {
            abc.sum(4, 5);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //public void m1(List<String> list){}
    public void m1(List<Integer> list) {
    }
}

/*class  Parent1  {     }
class Child extends Parent1 {    }*/

class ABC {
    public static int add(int a, int b) {
        System.out.println("1 ");
        return a + b;
    }

    public void sum(int a, int b) throws Exception {
        System.out.println("1 " + (a + b));
    }

}

class C extends ABC {
    public static int add(int a, int b) {
        System.out.println("2 ");
        return a + b;
    }

    public void sum(int a, int b)  {
        System.out.println("2 " + (a + b));
    }
}





