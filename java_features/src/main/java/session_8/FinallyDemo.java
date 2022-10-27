package session_8;

public class FinallyDemo {

    public static void main(String[] args) {
       int result = show();
        System.out.println("Result " + result);
    }

    public static int show() {
        try {
            System.out.println("I am inside try");
            throw new NullPointerException("I am null");
            //return 0;
        } /*catch (NullPointerException ex) {
            System.out.println("I am inside catch block");
            return 1;
        } */catch (Exception ex ) {
            System.out.println("I am parent of every exception");
            return 2;
        } finally {
            System.out.println("I am Boss, You have to give me preference everytime");
            return 3;
        }
    }
}
