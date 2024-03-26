package thread.pp.basic;

import java.util.List;

public class Worker3 implements Runnable {
    private final List<Integer> l;
    private final int s, e, val;
    private final Number number;

    public Worker3(List<Integer> l, int s, int e, int val, Number number) {
        this.l = l;
        this.s = s;
        this.e = e;
        this.val = val;
        this.number = number;
    }

    public void run() {
        int curr = 0;

        for (int i = s; i < e; i++) {
           /* if (l.get(i) == val) {
                number.incr();
            }*/
            if (l.get(i) == val) {
                curr++;
            }
        }
        number.plus(curr);
    }
}
