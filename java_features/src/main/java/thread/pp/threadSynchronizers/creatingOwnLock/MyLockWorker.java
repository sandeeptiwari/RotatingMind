package thread.pp.threadSynchronizers.creatingOwnLock;

public class MyLockWorker implements Runnable {

    private final MyLock myLock;

    public MyLockWorker(MyLock myLock) {
        this.myLock = myLock;
    }

    @Override
    public void run() {
        try {
            myLock.lock();
            Thread.sleep(1000);
            start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            myLock.unlock();
        }
    }

    private void start() {

        try{
            myLock.lock();
            end();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            myLock.unlock();
        }
    }

    private void end() {
        try{
            myLock.lock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            myLock.unlock();
        }
    }

}
