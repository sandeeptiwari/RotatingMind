public class CustomeQueue {
    private int size = 0;
    private int front = 0;
    private int rear = 0;
    private int maxSize;
    private int[] queue = null;

    public CustomeQueue(int size){
        this.size = size;
        rear = -1;
        maxSize = 0;
        queue = new int[size];
    }

    public void add(int ele){
        rear++;
        queue[rear] = ele;
        maxSize++;
    }

    public int poll(){
        int ele = queue[front];
        front++;
        maxSize--;
        return ele;
    }
}
