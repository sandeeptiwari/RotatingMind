package interview.jvm;

/**
 *  A.class -> Load The class -> verify -> no then reject
 *                                | yes (verification, byte code verifier)
 *          Allocate the space for class's static variable with the default value
 *                                | (preparation)
 *          Allocated all instance variable with default variable
 *                                | (Resolution)
 *          Load all referenced classes, this call could be accessing other classes refernces
 *                                |
 *          Initialize the variable of static block as wel as instance initialize block with real value
 *
 */
interface ParentInterface {
    int value1 = new JvmDemo().getValue();
    int value2 = new JvmDemo().getValue7();
    static void show() {
        System.out.println("ParentInterface: show");
    }
}
class Parent {
    Parent() {
        System.out.println("Parent: constructor");
    }
}
class ParentClass {
    static {
        System.out.println("ParentClass -> static initializer");
    }
    {
        System.out.println("ParentClass -> instance initializer");
    }
    ParentClass () {
        System.out.println("ParentClass -> constructor");
    }
}

class Child extends ParentClass implements ParentInterface {
    public static final int CHILD_PROPERTY = 47; // no class will load for compiled copy
    public static final int CHILD_AUTO_PROPERTY = (int) (Math.random() * 5); // here  will load for non compiled copy

    Parent parent = new Parent();
    static {
        System.out.println("Child -> static init block");
    }
    Child () {
        System.out.println("Child -> constructor");
    }
    {
        System.out.println("Child -> init block");
    }
}

public class JvmDemo {
    {
        System.out.println("JvmDemo -> Init block");
    }
    static {
        System.out.println("JvmDemo -> static block");
    }
    static int getValue() {
        System.out.println("JvmDemo -> getValue()");
        return 3;
    }
    static int getValue7() {
        System.out.println("JvmDemo -> getValue7()");
        return 7;
    }
    public static void main(String[] args) throws Exception {
        System.out.println("JvmDemo ->  Main method started");
        System.out.println("JvmDemo ->  Child.CHILD_PROPERTY " + Child.CHILD_PROPERTY);
        System.out.println("JvmDemo -> Child.CHILD_AUTO_PROPERTY "+ Child.CHILD_AUTO_PROPERTY);
        System.out.println("JvmDemo ->  Instantiating Child");
        new Child();
        System.out.println("JvmDemo ->  ParentInterface.value1: " + ParentInterface.value1);
        ParentInterface.show();
    }
}

