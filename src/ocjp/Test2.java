package ocjp;


public class Test2 {

    public static void main(String[] args) {
        Test2 obj = new Test2();
        System.out.println(obj.find(20, 10));
    }

    public int find(int x, int y) {
        return (x < y) ? 0 : x -y;
    }
}
