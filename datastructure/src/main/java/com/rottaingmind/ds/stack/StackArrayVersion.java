package com.rottaingmind.ds.stack;

public class StackArrayVersion<T> {

    private T[] stack;
    private int count;

    public StackArrayVersion() {
        stack = (T[]) new Object[1];
    }

    public void push(T data) {
        if (count == stack.length) {
            resize(2 * count);
        }

        stack[count++] = data;

    }

    public T pop() {
        T ele = null;
        if (!isEmpty()) {
            ele = stack[--count];
            stack[count] = null;

            if (count > 0 && count == stack.length / 4) {
                resize(stack.length/2);
            }
        }
        return ele;
    }

    private boolean isEmpty() {
        return count == 0;
    }

    private void resize(int newSize) {
        T[] stackCopy = (T[]) new Object[newSize];
        for (int i = 0; i < count; i++) {
            stackCopy[i] = stack[i];
        }
        stack = stackCopy;
    }
}
