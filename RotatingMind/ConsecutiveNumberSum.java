/* Problem Statement : Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers? 
 * ==============================================================================================================================
 * Input : let say user input is 5
 *
 * output : So we can represent 5 as bellow
 * 5 = 2 + 3  
 * -> Here 2 and 3 are consecutive and its sume is 5 
 * There is no other such consecutive pair for 5 so final out put would be = 1
 * ==================================================================================================================================
 * Input: 15
 * Output : 15 = 1 + 2 + 3 + 4 + 5 -> these number are consecutive and its sum = 15 
 *  15 = 4 + 5 + 6 -> again numbers are in consecutive and its sum is = 15
 *  15 = 7 + 8
 * result would be = 3 because there are three ways we can write sum of consecutive numbers
 *===================================================================================================================================
 * Solution : Come to solution part- definitely we would aware with Gauss formula  
 *  sum = 1 + 2 + 3 + 4 ...... n
 *  sum = n*(n + 1)/2
 * Here we have to find out consecutive sum of a given number
 * Let's say number is N and its consecutive sum is like bellow
 * N = a + (a + 1) + (a + 2)+ .....+(a + L) -> where a is first term and L is last term
 * N = (1 + L)*a + L*(L + 1)/2
 * now what would be the first term, if are able to find out first, last term. Then we can easily find out possible consecutive sum.
 *
 * a = [N - (L * (L + 1) / 2)]/ ( L + 1 );
 * 
 * => L * (L + 1) = 2*N
 * for L = 1 to L * (L + 1) < 2*N 
 */
 public class ConsecutiveNumberSum{
     
     public int consecutiveSum(){
        int count = 0;
        
        for(int i = 1; i*(i + 1) < 2 * n; i++){
            
             float a = (float)[1.0 * N - (i * (i + 1) / 2)]/ ( i + 1 );
             
             if( a - (int)a == 0)
              count++
        }
       return count;
     }
 }
