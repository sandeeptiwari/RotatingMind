package ugc;

public class UGCTest {

    public static void main(String[] args) {
        UGCTest obj = new UGCTest();
        obj.start();
    }

    public void start() {
        long P[] = {3, 4, 5};
        int v = 10;
        long Q[] = method(P, v);
        System.out.println("V " + v);

        System.out.println(P[0] + P[1] + P[2] + " : "+ (Q[0] + Q[1] + Q[2]));
    }

    long[] method(long[] R, int v) {
        R[1] = 7;
        v = 13;
        return R;
    }
}
