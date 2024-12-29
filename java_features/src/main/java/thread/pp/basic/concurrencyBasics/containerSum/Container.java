package thread.pp.basic.concurrencyBasics.containerSum;

import java.util.ArrayList;
import java.util.List;

public class Container {

    private final List<Integer> numbers;
    private int curr;

    public Container() {
        this.numbers = new ArrayList<>();
        for(int i = 1;i<=10000;i++) this.numbers.add(i);
        this.curr = 0;
    }

    public synchronized int pluck(){
        if(curr == numbers.size()) return -1;
        int val = this.numbers.get(curr);
        curr++;
        return val;
    }
}
