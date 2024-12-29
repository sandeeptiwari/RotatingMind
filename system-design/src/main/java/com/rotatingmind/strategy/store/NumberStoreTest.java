package com.rotatingmind.strategy.store;


import com.rotatingmind.strategy.inserter.OrderedInserter;
import com.rotatingmind.strategy.searcher.BinarySearcher;

public class NumberStoreTest {

    public static void main(String[] args) {
        NumberStore numberStore = new NumberStore(
                new OrderedInserter(),
                new BinarySearcher()
        );
        numberStore.insert(1);
        numberStore.insert(0);
        numberStore.insert(10);
        numberStore.insert(2);
        System.out.println(numberStore.search(10));
    }

}
