package ocp;

import java.io.FileNotFoundException;

public class Demo1 {

    public static void addToInt(int x, int amountToAdd) {
        x = x + amountToAdd;
    }

    public static void main(String[] args) {
        var a = 15;
        var b = 12;

        Demo1.addToInt(a, b);
        System.out.println(a);
    }

    public void main() {
        System.out.print("a");
        /*try (StringBuilder reader = new StringBuilder()) {
            System.out.print("b");
            throw new IllegalArgumentException();
            } catch (Exception e || RuntimeException e) {
              System.out.print("c");
               throw new FileNotFoundException();
            } finally {
                System.out.print("d");
            } }*/
    }
}
