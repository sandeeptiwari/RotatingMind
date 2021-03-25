package ds.stack;

public class StackDemo {

    public static void main(String[] args) {
        // Stack<Integer> stack = new Stack<>();
        StackArrayVersion<Integer> stack = new StackArrayVersion<>();
        stack.push(1);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.pop());

    }
}
