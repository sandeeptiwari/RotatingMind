package reflection.session1;

import java.lang.reflect.Method;

public class MyClassB extends MyClassA {

    public static void main(String[] args) {
        Object o = new MyClassB();
        Class c = o.getClass();

        while(c != null) {
            Method[] m = c.getMethods();

            System.out.println(c.getSuperclass().getName());

            c = c.getSuperclass();
        }
    }
}
