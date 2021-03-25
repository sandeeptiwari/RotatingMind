import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQ {

    public static void main(String... args) {
        CustomStackByQ stack = new CustomStackByQ();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);


        while (stack.size() > 0) {
           System.out.println(stack.pop());
        }
    }
}

class CustomStackByQ {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int length;

    public void push(int value) {
        q1.add(value);
        length++;
    }

    public int pop() {
        int size = q1.size() - 1;
        for (int i = 0; i< size; i++) {
            int ele = q1.remove();
            q2.add(ele);
        }
        int popedEle = q1.poll();
        length--;
        Queue<Integer> temp = q2;
        q2 = q1;
        q1 = temp;
        return popedEle;
    }

    public int size(){
        return length;
    }
}
