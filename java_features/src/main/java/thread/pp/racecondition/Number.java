package thread.pp.racecondition;

public class Number {
    private int x;

    public int getX() {
        return x;
    }

    public void increment() {
        x++;  // <-- critical section
        /**
         * x = x + 1 - 3 steps : 1 : Fetch, 2: x + 1, 3- write
         * critical section
         * T1 f(5) | T2 f(5) | T1 f(6) | T2 f(6) == Race condition
         */
    }
}
