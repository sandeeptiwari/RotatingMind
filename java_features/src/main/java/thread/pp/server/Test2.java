package thread.pp.server;


public class Test2 {

    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = new ThreadPool(3);
        Task t1 = new Task("I love concurrency", 1, 5);
        Task t2 = new Task("I love LLD", 6, 2);
        Task t3 = new Task("I love UI/UX", 4, 0);

        threadPool.submit(t1);
        threadPool.submit(t2);
        threadPool.submit(t3);
    }
}
