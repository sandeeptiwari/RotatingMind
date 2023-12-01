package thread.pp.third;

public class NumberStore {
    private int num;

    public NumberStore() {
        this.num = 0;
    }

    public int getNum() {
        return num;
    }

    public void increment(Object lock) {
        /** x = x + 1,
         * 1- fetch from RAM,
         * 2- increment by 1 (num + 1)
         * 3- store back to RAM
         **/
            num++; //critical section
    }
}
