package course.intro_class;



public class HelloJava {

    static {
        System.out.println("I am static block");
    }

    {
        System.out.println("I am init block");
    }

    public static void main(String[] args) {
        char covid = '\u0040';
        System.out.println("I am main method" + covid);
    }
}
