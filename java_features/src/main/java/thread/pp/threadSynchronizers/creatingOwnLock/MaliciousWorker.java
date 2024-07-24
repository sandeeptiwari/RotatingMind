package thread.pp.threadSynchronizers.creatingOwnLock;

public class MaliciousWorker implements Runnable{

    private final MyLock myLock;

    public MaliciousWorker(MyLock myLock) {
        this.myLock = myLock;
    }

    @Override
    public void run() {
        myLock.unlock();
    }
}
