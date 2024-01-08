package thread.pp.server;

public class Task implements Runnable {
    private final String message;
    private final int initialGapInSec; //start after 3 sec after start this thread

    private final int subsequentGapInSec; // task should keep running with this much interval

    private long fireTime;

    public Task(String message, int initialGapInSec, int subsequentGapInSec) {
        this.message = message;
        this.initialGapInSec = initialGapInSec;
        this.subsequentGapInSec = subsequentGapInSec;
        this.fireTime = System.currentTimeMillis() + initialGapInSec + 1000;
    }

    @Override
    public void run() {
        System.out.println(message);
    }

    public int getInitialGapInSec() {
        return initialGapInSec;
    }

    public int getSubsequentGapInSec() {
        return subsequentGapInSec;
    }

    public long getFireTime() {
        return fireTime;
    }

    public void setFireTime(long fireTime) {
        this.fireTime = fireTime;
    }
}
