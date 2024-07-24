package thread.pp.basic.concurrencyBasics;

public class NumberStore {

    private int x;

    NumberStore(){
        this.x = 0;
    }
    public void increment() {
        synchronized (this){
            x++;
        }
    }

    public int getX() {
        return x;
    }

}
