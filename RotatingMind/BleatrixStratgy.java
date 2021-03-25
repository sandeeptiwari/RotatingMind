/*
Bleatrix Trotter the sheep has devised a strategy that helps her fall asleep faster. First, she picks 
a number N. Then she starts naming N, 2 × N, 3 × N, and so on. Whenever she names a number, she thinks 
about all of the digits in that number. She keeps track of which digits (0, 1, 2, 3, 4, 5, 6, 7, 8, and 9) 
she has seen at least once so far as part of any number she has named. Once she has seen each of the ten 
digits at least once, she will fall asleep.

Bleatrix must start with N and must always name (i + 1) × N directly after i × N. For example, suppose 
that Bleatrix picks N = 1692. She would count as follows:

N = 1692. Now she has seen the digits 1, 2, 6, and 9.
2N = 3384. Now she has seen the digits 1, 2, 3, 4, 6, 8, and 9.
3N = 5076. Now she has seen all ten digits, and falls asleep.
What is the last number that she will name before falling asleep? If she will count forever, print 
INSOMNIA instead.

Input

The first line of the input gives the number of test cases, T. T test cases follow. Each consists of 
one line with a single integer N, the number Bleatrix has chosen.

Output

For each test case, output one line containing Case #x: y, where x is the test case number 
(starting from 1) and y is the last number that Bleatrix will name before falling asleep, according 
to the rules described in the statement.

Limits

1 ≤ T ≤ 100.
Small dataset

0 ≤ N ≤ 200.
Large dataset

0 ≤ N ≤ 106.
Sample


Input 
 	
Output 
 
5
0
1
2
11
1692

Case #1: INSOMNIA
Case #2: 10
Case #3: 90
Case #4: 110
Case #5: 5076


In Case #1, since 2 × 0 = 0, 3 × 0 = 0, and so on, Bleatrix will never see any digit other 
than 0, and so she will count forever and never fall asleep. Poor sheep!

In Case #2, Bleatrix will name 1, 2, 3, 4, 5, 6, 7, 8, 9, 10. The 0 will be the last digit 
needed, and so she will fall asleep after 10.

In Case #3, Bleatrix will name 2, 4, 6... and so on. She will not see the digit 9 in any number 
until 90, at which point she will fall asleep. By that point, she will have already seen the 
digits 0, 1, 2, 3, 4, 5, 6, 7, and 8, which will have appeared for the first time in the numbers 
10, 10, 2, 30, 4, 50, 6, 70, and 8, respectively.

In Case #4, Bleatrix will name 11, 22, 33, 44, 55, 66, 77, 88, 99, 110 and then fall asleep.

Case #5 is the one described in the problem statement. Note that it would only show up in the 
Large dataset, and not in the Small dataset.
*/
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class BleatrixStratgy{
	
	/*
	  1- bleartrix count will come as a parameters
	  2- 10= 1,0
	*/
	public int aSleepWith(int count, Set<Integer> set){
		
		while(count > 0){
			int rem = count % 10;
			//System.out.println("rem "+rem);
			set.add(rem);	
			count = count/10;
			//System.out.println((count > 1)+" count "+count);
		}
		return set.size();
	}
	
	public static void main(String args[]){
		int counter = 0, c = 0, incrementor = 1;
		Set<Integer> set = new HashSet<Integer>(10);
		BleatrixStratgy strategy = new BleatrixStratgy();
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		
		int [] counts = new int[testCases];
		while(counter < testCases){
			int count = sc.nextInt();
			counts[counter] = count;
			counter++;
		}
		for(int i = 0; i < counts.length; i++){
			c = counts[i];
			//System.out.println("cc "+c);
			if(c == 0){
				System.out.println("INSOMNIA");
				continue;
			}
			int len = set.size();
			//System.out.println("len "+len);
			int a = -1;
			while(len < 10){
				
				a = c * incrementor;
				//System.out.println("a "+a);
				len = strategy.aSleepWith(a, set);
				//len = set.size();
				//System.out.println("Len "+len);
				incrementor += 1;
			}
			if(len == 10){
				System.out.println(a);
				set.clear();
				incrementor = 1;
			}
		}
	}
}