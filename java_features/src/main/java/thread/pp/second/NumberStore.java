package thread.pp.second;

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
        /**
         * If with thread would have 2 dif lock, in that case
         * both thread can access critical section at same time
         * So lock must me the same for both teh thread
         */
        synchronized (lock) {
            num++; //critical section
        }

    }
}
