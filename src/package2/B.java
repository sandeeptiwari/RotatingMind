package package2;

import package1.A;

public class B extends A {
    int y = 10;

    public void print(){
        A a = new A();
        //System.out.println(a.y + y);
    }

    public void show(Integer a, Integer b){
        System.out.println("Wraper");
    }

    public void show(int a, int b){
        System.out.println("Primitive");
    }

    public void show(int... a){
        System.out.println("var-args");
    }

    public static void main(String...args){
        B b = new B();

        b.show(4, 5);
    }
}
