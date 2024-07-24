package thread.pp.racecondition;

public class TestRaceCondition {

    public static void main(String[] args) throws InterruptedException {
        Number num = new Number();
        RaceConditionWorker w1 = new RaceConditionWorker(num);
        RaceConditionWorker w2 = new RaceConditionWorker(num);

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Total :: " + num.getX());
    }
}
