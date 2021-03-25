/**
 * 10, 20, 30, 40, 50, 60
 */
public class CustomStack {
    int size;
    private int[] stack;
    private int top = 0;

    public CustomStack(){
        size = 10;
        stack = new int[size];
    }

    public CustomStack(int size){
        stack = new int[size];
    }

    public void push(int ele){
        stack[top] = ele;
        top++;
    }

    public int pop() throws Exception{
        if (top == 0)
            throw new Exception("No element found in stack");
        int i = --top;
        int ele = stack[i];
        stack[i] = 0;

        return ele;
    }
}
