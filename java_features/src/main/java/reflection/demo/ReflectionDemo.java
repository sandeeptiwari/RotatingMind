package reflection.demo;

import java.lang.reflect.Constructor;

class MyClass {
    private MyClass() {
        System.out.println("My object create");
    }

    public void show() {
        System.out.println("I am not hidden");
    }
}
public class ReflectionDemo {

    public static void main(String[] args) throws Exception {

        //MyClass obj = new MyClass();

        Class<?> c = Class.forName("reflection.demo.MyClass");
        Constructor<?> con = c.getDeclaredConstructor();
        con.setAccessible(true);
        MyClass obj = (MyClass) con.newInstance();
        obj.show();
    }
}
