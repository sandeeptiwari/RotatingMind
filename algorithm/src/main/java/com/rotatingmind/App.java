package com.rotatingmind;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(isPowerOfTwo(32));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        if(n == 2 || n == 1) {
            return true;
        }

        float num = n / 2f;

        if(num % 1 != 0)
        {
            return false;
        }

        return isPowerOfTwo((int)num);
    }

    public boolean isPowerOfTwo1(int n)
    {
        boolean b = false ;
        if( n > 0 && ( n & ( n - 1 )) == 0 )
        {
            b = true ;
        }
        return b ;
    }
}
