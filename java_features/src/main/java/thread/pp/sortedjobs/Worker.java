package thread.pp.sortedjobs;

public class Worker implements Runnable {
    private final int value;

    public Worker(int value) {
        this.value = value;
    }

    /**
     * We need to understand, How threads works to your hardware.
     * Machine may have multiple CPU cores, A Thread lets call Thread1
     * That got scheduled on CPU core1
     * core1 -> T1
     * core2 -> T2
     * core3 -> T3
     *
     * Now when that happen, when thread need to transform that variable it creates copy of that variable
     * Have put this copied variable into local CPU. Now machine flashes these value back into RAM time to time
     * What if certain thread made do any change and that change still didn't flush into Main Memory. Then Second thread will not read
     * update value of that variable this issue known as memory visibility. There is no guaranty if any thread change will reflect into main memory after
     * any change
     *
     * Volatile: Any changes made by a thread gets immediately flushd to main memory, ensures high visibility!!!
     */
    @Override
    public void run() {
        while(value > PrintedSortedNums.num) {}
        System.out.println(PrintedSortedNums.num);
        PrintedSortedNums.num++;
    }
}
