package com.sandi.jvm;

public class MemoryLeakDemo {

    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println(stack.pop());

        System.out.println(stack.pop());
    }
}


class CustomStack {
    Object[] elements = new Object[10];
    int top = 0;

    public boolean isFull() {
        return top == elements.length - 1;
    }

    public void push(Object obj) {
        if (!isFull()) {
            elements[top++] = obj;
        } else {
            //double the size and store
        }
    }

    public Object pop() {
        if (top == 0) {
            throw new ArrayStoreException("We dont have, what you looking for");
        }
        Object popped = elements[--top];
        elements[top] = null;
        System.out.println("Popped " + popped);
        return popped;
    }
}
