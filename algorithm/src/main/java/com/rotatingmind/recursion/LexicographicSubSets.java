package com.rotatingmind.recursion;

public class LexicographicSubSets {

    public void lexicsS(int[] a, int[] aux, int size, int nextIndex) {
        for (int i = 0; i < size-1; i++) {
            System.out.println(aux[i]);
        }
        if(nextIndex == a.length) {
            return;
        }

        for (int i = nextIndex; i < (a.length-1); i++) {
            aux[size] = a[nextIndex];
            lexicsS(a, aux, size, nextIndex);
        }
    }
}
