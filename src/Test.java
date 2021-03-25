import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String... args) {
        CustomStack stack = new CustomStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        List<Employee> emps = new ArrayList<>();
        LinkedList li = new LinkedList();

        /*try {
            System.out.print("Top ele is :: " + stack.pop());
            System.out.print("Top ele is :: " + stack.pop());
            System.out.print("Top ele is :: " + stack.pop());
            System.out.print("Top ele is :: " + stack.pop());
            System.out.print("Top ele is :: " + stack.pop());
            System.out.print("Top ele is :: " + stack.pop());
            System.out.print("Top ele is :: " + stack.pop());

        } catch (Exception e) {
            e.printStackTrace();
        }*/

      System.out.print("GCD==> "+GCD(8, 16));
    }

    public static int GCD(int m, int n) {
        if (m < n)
            return GCD(n, m);

        if (m % n == 0)
            return n;
        return GCD(n, m % n);
    }
}
