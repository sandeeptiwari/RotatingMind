package com.rotatingmind.recursion;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * Vasily has a number a, which he wants to turn into a number b. For this purpose, he can do two types of operations:
 *
 * multiply the current number by 2 (that is, replace the number x by 2·x);
 * append the digit 1 to the right of current number (that is, replace the number x by 10·x + 1).
 * You need to help Vasily to transform the number a into the number b using only the operations described above, or find that it is impossible.
 *
 * Note that in this task you are not required to minimize the number of operations. It suffices to find any way to transform a into b.
 *
 * Input
 * The first line contains two positive integers a and b (1 ≤ a < b ≤ 109) — the number which Vasily has and the number he wants to have.
 *
 * Output
 * If there is no way to get b from a, print "NO" (without quotes).
 *
 * Otherwise print three lines. On the first line print "YES" (without quotes). The second line should contain single integer k — the length of the transformation sequence. On the third line print the sequence of transformations x1, x2, ..., xk, where:
 *
 * x1 should be equal to a,
 * xk should be equal to b,
 * xi should be obtained from xi - 1 using any of two described operations (1 < i ≤ k).
 * If there are multiple answers, print any of them.
 *
 *
 * inputCopy
 * 2 162
 * outputCopy
 * YES
 * 5
 * 2 4 8 81 162
 * inputCopy
 * 4 42
 * outputCopy
 * NO
 * inputCopy
 * 100 40021
 * outputCopy
 * YES
 * 5
 * 100 200 2001 4002 40021
 *
 */
public class TransformAToB {

    public static Deque<Integer> transform(int a, int b, Deque<Integer> stack) {
        if (b <= 0 || a == b) {
            return stack;
        }

        if (b % 2 == 0) {
           b = b / 2;
           stack.push(b);
        } else if ((b - 1 ) % 10 == 0) {
            b -= 1;
            b = b / 10;
            stack.push(b);
        }

        return transform(a, b, stack);
    }

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        //int a = 2;
        //int b = 162;
        int a = 100;
        int b = 40021;
        Deque<Integer> transform = transform(a, b, stack);
        if (transform != null && !Objects.equals(transform.peek(), a)) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            assert transform != null;
            System.out.println(transform.size() + 1);
            while(transform.peek() != null) {
                System.out.print(transform.pop() + " ");
            }
            System.out.print(b);
        }
    }
}
