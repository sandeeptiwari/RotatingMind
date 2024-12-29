package com.rottaingmind.ds.stack.minstack;

public class EfficientMinStack {
    private long[] arr = new long[30];
    int top = -1;
    long currMin = Integer.MAX_VALUE;

    public void push(long x) {
        if (isEmpty()) {
            arr[++top] = x;
            currMin = x;
            return;
        }

        if (x < currMin) {
            arr[++top] = (2 * x - currMin);
            currMin = x;
        } else {
            arr[++top] = x;
        }
    }

    // ele  = 2 * currMIn - previousMin
    // previousMin = 2 * currMin - ele
    public long pop() {
        if (isEmpty()) {
            throw new StackOverflowError("Stack is Empty");
        }

        if (arr[top] < currMin) { // point of change
            currMin = 2 * currMin - arr[top];
        }
      return arr[top--];
    }

    public long getMin() {
        return currMin;
    }

    public long peek() {
        return arr[top] < currMin ? currMin : arr[top];
    }

   public boolean isEmpty() {
        return top == -1;
   }

}
