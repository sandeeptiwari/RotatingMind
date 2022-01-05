package com.rottaingmind.ds.stack.applications.max;

public class MaxElement {

    public static void main(String[] args) {
        MaxItemInStack maxItemStack = new MaxItemInStack();
        maxItemStack.push(10);
        maxItemStack.push(5);
        maxItemStack.push(1);
        maxItemStack.push(12);
        maxItemStack.push(11);

        System.out.println("Max Item : " + maxItemStack.getMax());
    }
}
