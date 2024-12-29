package com.rotatingmind.recursion;

import java.util.Arrays;

/*
  We have N pair of braces we have to print all balance paranthese
  N = 3
  1 - ((()))
  2- (()())
  3- (()) ()
  4- () (())
  5- () () ()

  P1: Every closing brace has opening counter part
  P2: count of opening braces >= count of closing braces
  P3: ()____ : at index  2 , we can put only opening (, means if ( == ) then next would be always (
  P4: If count of opening braces is equal to count of closing braces. Then I am 100% sure next parantheses can be opening brace
  P5: ((____: Here at index 2 we can put open and close both braces
  P6: (((___: Here Open brace == to n then next brace 100% would be closing brace only


 E.g =>
    l = 0,   r = 0, s = ""

    1             0            "("         -> all bracess available then will start from open one
      a) r can be close   1, 1 "()"
         ->
      b) l can be increase with one open brace --> 2, 0  "(("
         -> Here open brace is > close one and still be open brace != n, so l can be both open/close braces
           b1)  3 0  "((("
               b1.1)-> Since we exhausted our open braces where open braces == n, now only closing braces can come
                   3 1 "((()" , 3  2 "((())", 3, 3 "((()))"
           b2)  2 1   "(()"
              b2.1) Since open braces is greater that closing braces can have both braces
                   2 2  "(())"  OR  3 1 "(()("
                   b2.1.1 -> opening braces exhausted then only closing will come  3 3 "(()())"

 */
public class BalanceParantheses {

    private static void pp(int n, int l, int r, int i, String[] s ) {
        if (i == 2 * n) {
            Arrays.stream(s).forEach(System.out::print);
            System.out.println("\n");
            return;
        }

        if (l == r) {
            s[i] = "("; // l == r
            pp(n, l + 1, r, i+1, s);
        } else if (l > r) {
            if (l == n) {
                s[i] = ")";
                pp(n, l, r+1, i+1, s);
            } else {
                s[i] = "(";
                pp(n, l + 1, r, i+1, s);
                s[i] = ")";
                pp(n, l , r + 1, i+1, s);
            }
        }

    }

    public static void main(String[] args) {
        String[] s = new String[6];
        pp(3, 0, 0, 0, s);
    }
}
