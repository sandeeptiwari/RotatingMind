package com.rotatingmind.math;

import java.util.Arrays;

public class Exact3Divisors {

    public static void main(String[] args) {
        System.out.println(numbersWith3Divisors(50));
    }

    public static int exactly3Divisors(int N)
    {
        if (N < 4) {
            return 0;
        }


        int counter = 0;

        for(int i = 4; i <= N; i++) {
            int localCounter = 0;
            int j = 1;

            while(j <= i) {

                if(i % j == 0) {
                    localCounter++;
                }
                j++;
            }

            if (localCounter == 3) {
                counter++;
            }
        }

        return counter;
    }

    public static int exactly3DivisorsV1(int N)
    {
        if (N < 4) {
            return 0;
        }

        int counter = 0;

        for(int i = 4; i <= N; i++) {
            double root = Math.sqrt(i);

            if (root % 1 == 0 && isPrime(root)) {
                counter++;
            }
        }

        return counter;
    }

    public static boolean isPrime(double num) {
        if (num <= 1) {
            return false;
        }

        if (num == 2 || num == 3) {
            return true;
        }

        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= num; i++) {

            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }


    public static int numbersWith3Divisors(int n)
    {
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        int counter = 0;

        for (int p = 2; p*p <= n; p++)
        {
            if (prime[p] == true)
            {
                for (int i=p*2; i<=n; i += p)
                    prime[i] = false;
            }
        }

        for (int i=0;  i*i <= n ; i++) {
            if (prime[i]) {
                counter++;
            }
        }
        return counter;
    }


    public boolean isPrime(int n)
    {
        if(n<=1)
            return false;

        for(int i=2;i<=Math.sqrt(n);i++)
            if(n%i==0)
                return false;

        return true ;
    }

    // method to check the numbers which has exactly 3 divisors
    public int exactly3DivisorsV2(int N)
    {
        //Initializing counter to zero
        int counter=0;
        N = (int)Math.sqrt(N);

        //Running a loop from 1 to sqrt(N)
        for(int i=1;i<=N;i++)
        {
            // A number N only has 3 divisors if it is a
            // perfect square and its square  root is a prime number,
            // and we know the number of perfect squares less than N which
            // is sqrt(N), so just checking if i is prime or not
            if(isPrime(i))
                counter++;
        }
        return counter;
    }

}
