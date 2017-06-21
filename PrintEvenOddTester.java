public class PrintEvenOddTester {

    public static void main(String... args) {
        Printer print = new Printer();
        Thread t1 = new Thread(new TaskEvenOdd(print, 10, false));
        Thread t2 = new Thread(new TaskEvenOdd(print, 10, true));
		t1.setName("Thread 1");
        t1.start();
        t2.start();
		t2.setName("Thread 2");
    }

}

class TaskEvenOdd implements Runnable {

    private int max;
    private Printer print;
    private boolean isEvenNumber;

    TaskEvenOdd(Printer print, int max, boolean isEvenNumber) {
        this.print = print;
        this.max = max;
        this.isEvenNumber = isEvenNumber;
    }

    @Override
    public void run() {

        //System.out.println("Run method");
        int number = isEvenNumber == true ? 2 : 1;
        while (number <= max) {

            if (isEvenNumber) {
                System.out.println("Even :"+ Thread.currentThread().getName());
                print.printEven(number, this);
                //number+=2;
            } else {
                System.out.println("Odd :"+ Thread.currentThread().getName());
                print.printOdd(number, this);
                // number+=2;
            }
            number += 2;
        }
		
		
    }

}

class Printer {

    boolean isOdd = false;

    synchronized void printEven(int number, TaskEvenOdd taskStatus) {
		System.out.println(isOdd+" printEven00:");
        while (isOdd == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Even:" + number);
        isOdd = false;
        notifyAll();
		//taskStatus.showThreadState();
		System.out.println(isOdd +" printEven11 ");
    }

    synchronized void printOdd(int number, TaskEvenOdd taskStatus) {
		System.out.println("printOdd00: "+isOdd);
        while (isOdd == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Odd:" + number);
        isOdd = true;
        notifyAll();
		//taskStatus.showThreadState();
		System.out.println(isOdd+" printOdd11: ");
    }

}