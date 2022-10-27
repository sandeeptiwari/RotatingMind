package oops;

import oops.overriding.Animal;
import oops.overriding.Cat;

import java.io.FileOutputStream;

public class Session6Demo {
    int id = 10;
    static String name = "Sandeep";

    static {
        //System.out.println("Static block");
    }

    static void iamStatic() {
        System.out.println("I couldnt access instance " + name);
    }

    static void otherStatic() {
        iamStatic();
        System.out.println("Other static");
    }


    void iAmInstanceMethod() {
        id = 20;
    }

    void update(int newAge) {
       // #2
        newAge = 45;
        //#3
    }

    void update(Person person) {
        // #2
        person.age = 45;
        //#3
    }

    public static void main(String[] args) {
        /*Person p = new Person();
        p.getPersonIntro();
        // id = 20;
        String[] arr = new String[6];

        Session6Demo demo = new Session6Demo();
        System.out.println("Id - " + demo.id); //10
        demo.iAmInstanceMethod();  //update the value of id as 20
        System.out.println("Id - " + demo.id); // 20

        //Scenario - 2

        int age = 42; //#1
        demo.update(age);
//#4
        System.out.println("Age " + age);//42*/


        //Session6Demo demo = new Session6Demo();
        //int aa[] = null;
        //demo.varArgDemo(true);
    }

    // constructor -> its name would as class name
    // it would not have any return type ; return
    // initilize state of object
    //this
    static void constructorExample() {
       Person p = new Person();
       p.getPersonIntro();
    }

    // vararg -> ...

    public void varArgDemo(boolean i, int ...a) {
        System.out.println(a.length);//NullPoi
    }

    // method overloading:
     static void overloadingDemo() {
         byte a = 10;
         char b = 'c';

         Person p = new Person();
         p.update(a);// ?  Short version
         p.update(b); //? char version
         p.update(null); // String
     }



}
