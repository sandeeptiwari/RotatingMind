package thread.pp.fifth;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        NumStore numStore = new NumStore();
        for (int i = 0; i < 100000; i++) {
            Thread t = new Thread(new Worker(numStore));
            int curr = numStore.getW();
            t.start();

            while (curr == numStore.getW()) {}

            if (!(numStore.getX() == numStore.getY() &&
                    numStore.getY() == numStore.getZ() &&
                    numStore.getZ() == numStore.getW())) {
                System.out.println(numStore.getX() + " "
                + numStore.getY() + " "
                + numStore.getZ() + " "
                + numStore.getW());

                t.join();
            }
        }
    }
}
