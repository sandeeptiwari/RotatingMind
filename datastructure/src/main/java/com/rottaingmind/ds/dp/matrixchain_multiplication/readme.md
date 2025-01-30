1.The expression for calculating cost works when it is" ans = Math.min(ans,(calcAns(i,k,arr)+calcAns(k+1,j,arr)+(arr[i-1]*arr[k]*arr[j])));" and not

"ans = Math.min(ans,(calcAns(i,k,arr)+calcAns(k+1,j,arr)+(arr[i]*arr[k]*arr[j])));"



where cost = (arr[i-1]*arr[k]*arr[j]) and not (arr[i]*arr[k]*arr[j]) , why are we considering i-1 and not i since we need the row value of ith matrix , not able to understand this and also sir explains it as row of i , can you please point me out on this.



2.Why do we invoke the function as  return calcAns(1,N-1,arr) and not  return calcAns(0,N-1,arr)



class Solution{

    static int matrixMultiplication(int N, int arr[])

    {

        // code here

        

        return calcAns(1,N-1,arr);

    }

    

    static int calcAns(int i,int j,int arr[])

    {

        if(i==j)

        {

            return 0;

        }

        

        int ans = Integer.MAX_VALUE;

        

        for(int k=i;k<j;k++)

        {

            ans = Math.min(ans,(calcAns(i,k,arr)+calcAns(k+1,j,arr)+(arr[i-1]*arr[k]*arr[j])));

        }

        

        return ans;

    }

}





likeButton
Likes . 0
replyBtnReply
View 1 replies
shivam dashore
Timestamp: 00:00
can we also write TC N! instead of N^N ?

likeButton
Likes . 0
replyBtnReply
View 1 replies
Rohan Kucheriya
Timestamp: 00:00
package DynamicProgramming.MCM;

import java.util.Scanner;

public class MatrixChainMultiplication {
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
int n = in.nextInt();
int[] a = new int[n];
for(int k = 0; k<n; k++) a[k] = in.nextInt();
int[] min = new int[1];
System.out.println(solve(1, n, a));
}
private static int solve(int i, int j, int[] a){
if(i >= j) {
return 0;
}
int answer = Integer.MAX_VALUE;
for(int k = i; k<=j-1; k++){
int temp =  Math.min(answer, (solve(i, k, a) + solve(k+1, j, a) + a[i-1]*a[k]*a[j-1]));

           if(temp < answer) answer = temp;
       }
       return answer;
}
}



I've tried recursive solution for MCM, giving me wrong answer. I guess the problem is with selection the minimum.

package DynamicProgramming.MCM;

import java.util.Scanner;

public class MatrixChainMultiplication {
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
int n = in.nextInt();
int[] a = new int[n];
for(int k = 0; k<n; k++) a[k] = in.nextInt();
int[] min = new int[1];
System.out.println(solve(1, n, a));
}
private static int solve(int i, int j, int[] a){
if(i >= j) {
return 0;
}
int answer = Integer.MAX_VALUE;
for(int k = i; k<=j-1; k++){
int temp =  Math.min(answer, (solve(i, k, a) + solve(k+1, j, a) + a[i-1]*a[k]*a[j-1]));

           if(temp < answer) answer = temp;
       }
       return answer;
}
}



I've tried recursive solution for MCM, giving me wrong answer. I guess the problem is with selection the minimum.



For eg. for this test case

n = 4

10

30

5

60



It is returning 30000


System.out.println(solve(1, n, a));



instead of n , pass n-1 ,



and here
int temp =  Math.min(answer, (solve(i, k, a) + solve(k+1, j, a) + a[i-1]*a[k]*a[j-1]));
a[j] should be multiplied

like this
int temp =  Math.min(answer, (solve(i, k, a) + solve(k+1, j, a) + a[i-1]*a[k]*a[j]));

Likes . 0
Rohan Kucheriya
Yes I figured that out, but what was wrong with my version of code?




Likes . 0
Ankit Yadav
we have to  multiply a[j] in place of a[j-1] , dry run on pen and paper and you will get the point ,



and if we are using j index , then it should in bound , passing n will lead to out of bound ans a[0....n-1] is the indexing , hence we had to pass n-1


Assignments:
https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
https://leetcode.com/problems/burst-balloons/description/
https://leetcode.com/problems/burst-balloons/description/