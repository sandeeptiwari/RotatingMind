package oops;

/**
 * class, interface, enum, abstract, implements, extends, this, super
 * byte, short, char, int, long, float, double, boolean
 * break, continue, for, do, while, if, else, new, switch, default, case, goto try, catch, final, assert, throw, throws
 * package, import
 * public, private, protected
 * synchronized, instanceof, return, transient, static, void, finally, strictfp, volatile, const, native
 *
 * class A {
 *
 *     A() {}
 * }
 *
 * class B extends A {
 *     B() {
 *
 *     }
 * }
 * clas Test {
 *     main() {
 *         B b = new B();
 *     }
 *
 * }
 */
class Person {
    int id;
    String name;
    int age;
    char gender;
    short value;

    public Person(int id, String name, int age) {
        this();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    Person() {
        System.out.println("I am constructor");
        return;
    }

    public String getPersonIntro() {
        return "";
    }

    public boolean update(int age) {
        this.age = age;
        System.out.println("Int Version");
        return true;
    }

    public void update(String name) {
        System.out.println("String Version");
        this.name = name;
    }

   /* public void update(char gender) {
        System.out.println("Char Version");
        this.gender = gender;
    }*/

    public void update(short value) {
        System.out.println("short Version");
        this.value = value;
    }
}
