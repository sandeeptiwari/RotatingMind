Intro to Loops
When we have to perform a certain operation multiple times, then we take the help of loops.

Eg:

Let's say we need to print happy.

We can do this by using printf(“happy”);

But what if we need to print happy 5 times or 1000 times?

Shall we repeat the same code printf(“happy”) 1000 times?

No, this is not a good idea. Here we use the concept of loops.

While Loop
While loop:



Syntax:

while (condition) {

// Body of the loop

// code block to be executed repeatedly

}

Example:

#include <stdio.h>

int main() {

//also called loop control variable

int count = 0; // initialize a counter variable

// loop while count is less than 5

while (count < 5) {

printf("Hello, world!\n"); // print the text

count++; // increment the counter

}

return 0;

}


The flow of the program is as follows:

count is initialized to 0.
The condition count < 5 is evaluated. Since the count is initially 0, the condition is true, so the code block inside the loop is executed.
Inside the loop, "Hello, world!" is printed to the console, and the count is incremented to 1.
Steps 2 and 3 are repeated until the count reaches 5.
When the count becomes 5, the condition count < 5 becomes false, and the loop terminates.
The program exits.
Infinite Loop

Infinite-loop
Predict the output:

#include <stdio.h>

int main() {

    int c = 0; // initialize the counter

    // Infinite loop

    while (c != -1) {

        printf("Hello, world!\n"); // print the text

        c++; // increment the counter

    }

    return 0;

}

Since the loop condition c != -1 will always be true , the loop will continue to execute indefinitely, printing "Hello, world!" repeatedly.

This creates an infinite loop, which will only end when the program is forcefully terminated, for example, by manually stopping the execution or encountering a system-level interrupt.

Predict the output:

#include <stdio.h>

int main() {

    // Infinite loop

    while (1) {

        printf("Hello, world!\n"); // print the text

    }

    return 0;

}

In this case, the loop condition 1 is always true.
Therefore, the loop body will execute indefinitely, printing "Hello, world!\n" repeatedly.
This creates an infinite loop.
Output:

Hello, world!

Hello, world!

Hello, world!

...

Predict the output:

#include <stdio.h>

int main() {

    // Infinite loop

    while (0) {

        printf("Hello, world!\n"); // print the text

    }

    return 0;

}

Here, the loop condition 0 is always false.
Since the loop condition is always false, the loop body will not execute at all.
The loop will terminate immediately without printing anything.
Output: No output.

Printing Natural Numbers
Printing natural numbers
We have to print natural numbers till n.

#include <stdio.h>

int main() {

    int n, i;

    // Input the value of n from the user

    printf("Enter the value of n: ");

    scanf("%d", &n);

    i = 1; // Initialize loop control variable

    // Loop to print natural numbers till n

    while (i <= n) {

        // Print the current number

        printf("%d", i);

        // Print arrow if the current number is not the last one

        if (i < n) {

            printf(" -> ");

        }

        i++; // Increment loop control variable

    }

    printf("\n"); // Print newline after all numbers are printed

    return 0;

}

Output:

Enter the value of n: 5

1 -> 2 -> 3 -> 4 -> 5

Printing Odds and Evens
Program to print the first n even and odd numbers:

#include <stdio.h>

int main() {

    int n;

    printf("Enter the value of n: ");

    scanf("%d", &n);

    int c = 0; // Count variable

    int i = 1; // Incrementing variable

    while (c < n) {

        printf("%d ", i);

        i += 2; // Increment by 2 for odd numbers

        c++;

    }

    c = 0; // Reset count variable

    i = 2; // Reset incrementing variable for even numbers

    while (c < n) {

        printf("%d ", i);

        i += 2; // Increment by 2 for even numbers

        c++;

    }

    printf("\n");

    return 0;

}

Output:

Enter the value of n: 5

1 3 5 7 9

2 4 6 8 10

Printing Multiplication Table
Printing multiplication table
Write a program to print multiplication table of a number n.

#include <stdio.h>

int main() {

    int n;

 

    // Input the number for which multiplication table is required

    printf("Enter the number: ");

    scanf("%d", &n);

 

    int i = 1;

 

    // Print the multiplication table

    printf("Multiplication table of %d:\n", n);

    while (i <= 10) {

        printf("%d x %d = %d\n", n, i, n * i);

        i++;

    }

 

    return 0;

}

Output:

Enter the number: 5

Multiplication table of 5:

5 x 1 = 5

5 x 2 = 10

5 x 3 = 15

5 x 4 = 20

5 x 5 = 25

5 x 6 = 30

5 x 7 = 35

5 x 8 = 40

5 x 9 = 45

5 x 10 = 50

Factorial of N
You are given an integer N. You need to obtain the factorial of N. Factorial of a number is the product of all numbers from 1 to N. For example. factorial of 5 = 1 * 2 * 3 * 4 * 5 = 120

Approach:- Here we need to multiply all the numbers from 1 to N. So we can run a loop from 1 to N and start multiplying the number in some answer variable and return that answer.

Pseudo code:-

#include<stdio.h>

int main() {

int N;

scanf(“%d”, &N);

int ans = 1;

int i = 1;

while(i <= N) {

ans = ans * i;

i++;

}

printf(“%d”, ans);

return 0;

}

Note:

A factorial of a larger number will not fit into an int data type or even long.
We can run the above loop in reverse order also.
All Factors of N


Program to print all factors of a number n:



#include <stdio.h>

int main() {

    int n;

 

    // Input the number

    printf("Enter a number: ");

    scanf("%d", &n);

 

    printf("Factors of %d are: ", n);

 

    int i = 1;

    while (i <= n) {

        if (n % i == 0) {

            printf("%d ", i);

        }

        i++;

    }

 

    printf("\n");

 

    return 0;

}

output:

Enter a number: 12

Factors of 12 are: 1 2 3 4 6 12



Prime Testing
To check whether a number is prime or not, first we find the number of factors of that number, then

if number of factors >2 =>the number is not prime

if number of factors ==2 =>the number is prime



Program to check whether a number n is prime or not:

#include <stdio.h>

int main() {

    int n;

    int count = 0; // Count variable to store the number of factors

 

    // Input the number

    printf("Enter a number: ");

    scanf("%d", &n);

 

    int i = 1;

    while (i <= n) {

        if (n % i == 0) {

            count++; // Increment count if n is divisible by i without remainder

        }

        i++;

    }

 

    // A prime number has only two factors: 1 and itself

    if (count == 2) {

        printf("%d is a prime number.\n", n);

    } else {

        printf("%d is not a prime number.\n", n);

    }

 

    return 0;

}

Output:

Enter a number: 7

7 is a prime number.

Enter a number: 8

8 is not a prime number.

Sum of Digits of N
Sum of digits of n
Write a program to find the sum of digits of a number n:

#include <stdio.h>

int main() {

    int n, sum = 0;

 

    // Input the number

    printf("Enter a number: ");

    scanf("%d", &n);

 

    // Logic to find the sum of digits

    while (n != 0) {

        sum += n % 10; // Add the last digit to sum

        n /= 10; // Remove the last digit from n

    }

 

    // Print the sum of digits

    printf("Sum of digits: %d\n", sum);

 

    return 0;

}

Output:

Enter a number: 123

Sum of digits: 6

Explanation:

Extracting the last digit: When we take the number n and calculate n % 10, it gives us the remainder when n is divided by 10, which is effectively the last digit of n. For example:If n is 123, 123 % 10 gives 3.
Removing the last digit: After extracting the last digit, we want to remove it from the number so that we can move on to the next digit. We achieve this by performing integer division of n by 10. This effectively shifts all digits one place to the right, removing the last digit. For example:If n is 123, 123 / 10 gives 12.
Digits Pattern
Digits pattern:
Write a program to print digit pattern of a number n:

Example:

If n=370987

Print:

370987

37098

3709

370

37

3

#include <stdio.h>

int main() {

    int n;

 

    // Input the number

    printf("Enter a number: ");

    scanf("%d", &n);

 

    if (n == 0) {

        printf("0\n");

        return 0;

    }

 

    while (n > 0) {

        printf("%d\n", n);

        n = n / 10;

    }

 

    return 0;

}



Inside the loop, it prints the digits
Divides n by 10 (n = n / 10) to remove the last digit.
This process repeats until n remaind greater than zero.
Nested While Loops
Nested while loop

A nested while loop is a loop inside another loop. It allows you to execute a set of statements repeatedly within another set of statements. Each time the outer loop iterates, the inner loop executes completely.

Example:

#include <stdio.h>

int main() {

    int i = 1;

 

    // Outer loop

    while (i <= 3) {

        int j = 1;

 

        // Inner loop

        while (j <= 3) {

            printf("i: %d, j: %d\n", i, j);

            j++;

        }

 

        i++;

    }

 

    return 0;

}

Output:

i: 1, j: 1

i: 1, j: 2

i: 1, j: 3

i: 2, j: 1

i: 2, j: 2

i: 2, j: 3

i: 3, j: 1

i: 3, j: 2

i: 3, j: 3

Explanation:

The outer loop runs three times because i goes from 1 to 3. For each iteration of the outer loop, the inner loop runs three times because j goes from 1 to 3. This results in a total of nine iterations of the inner loop.

Printing Stars


Strong Number
Strong number
A strong number is a number in which the sum of the factorials of its digits equals the number itself.

For example, let's take the number 145:

1! + 4! + 5! = 1 + 24 + 120 = 145

#include <stdio.h>

int main() {

    int n;

    printf("Enter a number: ");

    scanf("%d", &n);

 

    if (n==0){

        printf("%d is not a strong number.\n", n);

        return 0; // Exit the program if the input is 0

    }

    int sum = 0, temp = n;

    // Loop to process each digit of the number

    while (n > 0) {

        int x = n % 10; // Extract the rightmost digit

        int fact = 1, i = 1;

        // Loop to calculate factorial of digit

        while (i <= x) { // Changed '>' to '<='

            fact *= i;

            i++;

        }

        sum += fact; // Add factorial of digit to sum

        n /= 10;   // Move to next digit

    }

    // Check if the number is strong or not

    if (sum == temp)

        printf("%d is a strong number.\n", temp);

    else

        printf("%d is not a strong number.\n", temp);

    return 0;

}

Output:

Enter a number: 145

145 is a strong number.

The program extracts each digit of the number one by one: 5, 4, 1.
For each digit, it calculates the factorial: 5! = 120, 4! = 24, 1! = 1.
The sum of these factorials is 120 + 24 + 1 = 145.
Since the sum is equal to the original number, the program prints "145 is a strong number."
Strong Numbers in a range
Program to print strong numbers in a range from 1 to n:

#include <stdio.h>

int main() {

    int n;

    printf("Enter a number: ");

    scanf("%d", &n);

 

    int num = 1;

    while (num <= n) {

        int sum = 0, temp = num;

        int digit = temp % 10; // Extract the rightmost digit

 

        // Loop to process each digit of the number

        while (temp > 0) {

            int fact = 1, i = 1;

            // Loop to calculate factorial of digit

            while (i <= digit) { // Changed 'x' to 'digit'

                fact *= i;

                i++;

            }

            sum += fact; // Add factorial of digit to sum

            temp /= 10;   // Move to next digit

            digit = temp % 10; // Update digit for next iteration

        }

        // Check if the number is strong or not

        if (sum == num) {

            printf("%d ", num); // Print the strong number

        }

        num++;

    }

 

    return 0;

}

Output:

Enter a number: 145

1 2 145

GCD of Two Numbers
We are given two integers. We need to find the Greatest Common Divisor (GCD) of both integers.

Eg.  a = 6 , b = 14

Divisors of a = 1, 2, 3, 6

Divisors of b = 1, 2, 7, 14

We need to return the greatest common divisors of both numbers. Here the GCD would be 2.

Approach:- Maximum GCD can be the minimum of a and b. So run a loop from 1 to min(a,b) and check if the current number can be a GCD and update the answer accordingly.

Pseudo code:-

#include<stdio.h>

int main() {

    int a, b;

    scanf("%d %d ", &a, &b);

    int i = 1, minm;

    if (a > b)

        minm = b;

    else

        minm = a;

    int ans = 1;

    while (i <= minm) {

        if (a % i == 0 && b % i == 0) {

            ans = i;

        }

        i++;

    }

    printf("%d", ans);

    return 0;

}



LCM of Two Numbers
LCM, which stands for Least Common Multiple, is the smallest positive integer that is divisible by both given numbers.

First, list out the multiples of each number until you find a common multiple.Then, select the smallest common multiple as the LCM.

Program to print the lcm of two numbers a and b:

#include <stdio.h>

int main() {

int a, b;

// Get the two numbers from the user

scanf("%d", &a);

scanf("%d", &b);

// Find the larger number (optional, but improves efficiency)

int max;

if (a > b) {

    max = a;

} else {

    max = b;

}

int ans = -1;//It's initialized to -1 as a flag to indicate that the LCM hasn't been found yet.

// Start checking from the larger number as the LCM can't be smaller

// Loop until both divisibility conditions are met (avoiding infinite loop)

while (max <= a * b) {

    if (max % a == 0 && max % b == 0 && ans == -1) {

      ans = max;

    }

    max++;

}

// Print result

printf("%d", ans);

return 0;

}

Intro to break keyword
When a break statement is encountered inside a loop, it immediately terminates the loop and transfers control to the statement immediately following the loop.
If the loop is nested within another loop, break only terminates the innermost loop in which it is placed.
Example:

Program to find the lcm of two numbers:

#include <stdio.h>

int main() {

int a, b;

// Get the two numbers from the user

scanf("%d", &a);

scanf("%d", &b);

// Find the larger number (optional, but improves efficiency)

int max;

if (a > b) {

    max = a;

} else {

    max = b;

}

int ans = -1;

// Start checking from the larger number as the LCM can't be smaller

// Loop until both divisibility conditions are met (avoiding infinite loop)

while (max <= a * b) {

    if (max % a == 0 && max % b == 0) {

      ans = max;

      break; // Exit the loop as soon as LCM is found

    }

    max++;

}

// Print result

printf("%d", ans);

return 0;

}

Benefits of using break:

Improved Efficiency: By exiting the loop as soon as the LCM is found, the code avoids unnecessary iterations, making it slightly more efficient.
Clarity: The break statement explicitly signals that the loop's purpose has been fulfilled, enhancing code readability.
Intro to For Loop
Syntax:

for (initialization; condition; increment/decrement) {

// code to be executed repeatedly

}


Breakdown of the Syntax:

Initialization: This part is executed only once at the beginning of the loop. It's used to declare and initialize a loop counter variable.
Condition: This expression is evaluated before each iteration of the loop. If it's true, the loop body executes. Once the condition becomes false, the loop terminates.
Increment/Decrement: It  is used to increment or decrement the counter, controlling how the loop progresses
Example:

#include <stdio.h>

int main() {

int i; // loop counter variable

for (i = 1; i <= 5; i++) { // initialization, condition, increment

    printf("Iteration %d\n", i);

}

return 0;

}

Program Flow Explanation:

Initialization: The variable i is declared and initialized to 1.
Condition Check: Before the first iteration, the condition i <= 5 is evaluated. Since 1 is less than or equal to 5, it's true.
Loop Body: The code inside the loop (printf("Iteration %d\n", i);) is executed. In this case, it prints "Iteration 1".
Increment: After the loop body execution, i is incremented to 2 (i++).
Condition Check: The condition i <= 5 is evaluated again (now with i as 2). Since 2 is still less than or equal to 5, it's true.
Loop Body: Steps 3 and 4 repeat, printing "Iteration 2".
Iterations Continue: This process continues until the condition becomes false. In this case, the loop iterates five times, printing "Iteration 1", "Iteration 2", ..., "Iteration 5".
Loop Termination: Once i becomes 6 after the fifth iteration, the condition i <= 5 is no longer true. The loop terminates, and the program execution continues after the loop.
Nth Fibonacci Number
Nth fibonacci number
Fibonacci numbers are a sequence of numbers in which each number is the sum of the two preceding ones, usually starting with 0 and 1. The sequence goes like this: 0, 1, 1, 2, 3, 5, 8, 13, 21, and so on.

F(n)=F(n−1)+F(n−2)

Here's a simple explanation of how the Fibonacci sequence works:

Start with the first two numbers, which are usually 0 and 1.
Add the two numbers to get the next number in the sequence.
Repeat step 2 to generate subsequent numbers.
To find the nth Fibonacci number, you would follow these steps for n−1 times, as the sequence starts from 0.

Program to find the nth fibonacci number;

#include <stdio.h>

int main() {

    int n;

    scanf("%d", &n);

    if (n <= 0) { 

        printf("0\n");

    }else{

        int prev=0,curr=1;

        for (int i = 2; i <= n; i++) {

            int temp = prev + curr;

            prev = curr;

            curr = temp;

        }

        printf("%d\n",curr);

    }

    return 0;

}

A Special Series
we are given a serie:
1, 11, 111, 1111, 11111........



write a program to print the sum of the series till nth term



Example:

if n = 5

sum = 1 + 11 + 111 + 1111 + 11111 = 12345



Approach: The loop iterates from 1 to n.In each iteration, the current term is updated by multiplying the previous term by 10 and adding 1. This effectively generates the series (1, 11, 111, ...) because each new term is formed by appending a '1' to the previous term. For example, if term is initially 0, then in the first iteration it becomes 1, in the second iteration it becomes 11, in the third iteration it becomes 111, and so on.

In the first iteration, term becomes 1 (as 0×10+1=1), and it prints 1.
In the second iteration, term becomes 11 (as 1×10+1=11), and it prints 11.
In the third iteration, term becomes 111 (as 11×10+1=111), and it prints 111.
#include <stdio.h>

int main() {

    int n;

    scanf("%d", &n);

 

    int term = 0;

    long long int sum = 0;

    for (int i = 1; i <= n; i++) {

        term = term * 10 + 1; // Generating each term of the series

      //  printf("%d ",term);

        sum += term; // Adding the current term to the sum

    }

    printf("%lld\n", sum);

    return 0;

}


Fractional Terms in a series
we are given a series:

1, 1/2, 1/3, 1/4, 1/5,...........



write a rpogram to print the sum of the series till nth term



Example:

if n = 5

sum = 1 + 1/2 + 1/3 + 1/4 + 1/5 = 2.283333

i.e the ith term will be : 1/i



#include <stdio.h>

int main() {

    int n;

    scanf("%d", &n);

 

    double sum = 0, x= 1.0;

    for(int i=1; i<=n; i++){

        sum+=x/i; //x is double and i is int ,so the whole value will be type casted to double

    }

 

    printf("%lf",sum);

    return 0;

}

Nested For Loop
Let at look at this code which contains a nested for loop:



#include <stdio.h>

int main() {



    for (int i = 1; i <= 3; i++) {

        for (int j = 1; j <= i; j++) {

            printf("%d %d \n", i, j); 

        }

        printf("*****\n"); 

    }

    return 0;

}

Output:

1 1

*****

2 1

2 2

*****

3 1

3 2

3 3

*****

Code execution:

In the first iteration of the outer loop (i = 1):
The inner loop executes once (j = 1), printing 1 1.
After the inner loop, ***** is printed.
In the second iteration of the outer loop (i = 2):
The inner loop executes twice (j = 1 to j = 2), printing 2 1 and 2 2.
After the inner loop, ***** is printed.
In the third iteration of the outer loop (i = 3):
The inner loop executes three times (j = 1 to j = 3), printing 3 1, 3 2, and 3 3.
After the inner loop, ***** is printed.


More on For Loop




All the slots inside the for loop are optional i.e the initialisation, condition and the update statement can also be skipped

for ( ;  ;  )
below are some examples:


In this example the initialisation statement  is skippped, still the code will work fine:



#include <stdio.h>

int main() {

    int i=0;

    for (; i <= 5; i++) {

        printf("%d\n",i);

    }

    return 0;

}


In this example initialisation and condition both the statement is skipped:



#include <stdio.h>

int main() {

    int i=0;

    for (; i <= 5;) {

        printf("%d\n",i);

        i++;

    }

    return 0;

}

In this example all the statements inside the for loop is skipped:



#include <stdio.h>

int main() {

    int i=0;

    for (; ;) {

        printf("%d\n",i);

        i++;

        if(i>5){

            break;

        }

 

    }

    return 0;

}

we can also use more than one variavle inside the for loop:



Example:



#include <stdio.h>

int main() {

    int i,j;

    for (i=0, j=1; i<5 && j<5 ;  i++, j+2) {

        printf("%d %d\n", i, j);

    }

    return 0;

}

Continue keyword
In this article, we will talk about the continue keyword. Consider a problem where you need to print the number from 1 to 50 except the multiple of 7.

Let’s code it.

#include<stdio.h>

int main(){

for(int i = 1; i <= 50; i++) {

if(i % 7 != 0) {

printf(“%d “,i);

}

}

return 0;

}

We can solve this problem using the continue keyword as well. The continue keyword immediately transfers the control to the next iteration. The above code using the continue keyword would look something like this.

#include <stdio.h>

int main(){

for(int i = 1; i <= 50; i++){

if(i % 7 == 0) {

continue;

}

printf(“%d “,i);

}

return 0;

}

Math Library
In C, the "math.h" library provides mathematical functions for performing various mathematical operations. Some of the important functions provided by the "math.h" library are:

sqrt(): Calculates the square root of a given number.
pow(): Calculates the power of a number.
ceil(): Rounds a number up to the nearest integer.
floor(): Rounds a number down to the nearest integer.
ceil() function:

The ceil() function returns the smallest integer greater than or equal to a given number.
For positive values, ceil() returns the next higher integer.
For negative values, ceil() returns the next lower integer (closer to zero).
Example:

#include <stdio.h>

#include <math.h>

int main() {

double x = 4.3;

printf("Ceil of %.1f is %.1f\n", x, ceil(x)); // Ceil of 4.3 is 5.0

double y = -4.3;

printf("Ceil of %.1f is %.1f\n", y, ceil(y)); // Ceil of -4.3 is -4.0 (closer to zero)

return 0;

}

floor() function:

The floor() function returns the largest integer less than or equal to a given number.
For positive values, floor() returns the next lower integer.
For negative values, floor() returns the next higher integer (closer to zero).
Example:

#include <stdio.h>

#include <math.h>

int main() {

double x = 4.3;

printf("Floor of %.1f is %.1f\n", x, floor(x)); // Floor of 4.3 is 4.0

double y = -4.3;

printf("Floor of %.1f is %.1f\n", y, floor(y)); // Floor of -4.3 is -5.0 (closer to zero)

return 0;

}

sqrt() function:

The sqrt() function calculates the square root of a given number.
It returns a floating-point value representing the square root.
Example:

#include <stdio.h>

#include <math.h>

int main() {

double x = 9.0;

printf("Square root of %.1f is %.1f\n", x, sqrt(x)); // Square root of 9.0 is 3.0

double y = 2.0;

printf("Square root of %.1f is %.5f\n", y, sqrt(y)); // Square root of 2.0 is approximately 1.41421

return 0;

}

Power Function
The pow() function in C is used to calculate the power of a number. It takes two arguments: the base and the exponent. It returns the value of the base raised to the power of the exponent.

#include <stdio.h>

#include <math.h>

int main() {

int x = pow(4,3);// if the exponent is big, we should use long long

printf("%d",x);

    return 0;

}

Output:

64

If we are expecting decimals we should use double or float data types:



int main() {

double x = pow(4,5.7);

printf("%lf",x);

    return 0;

}

Output:

2702.352201

Absolute Values
In this article, we will talk about some more functions.


fabs():- This function returns the absolute value of a number. Absolute value of a number means the distance of a number from 0.

Eg.

The absolute value of 7 = 7

The absolute value of -7 = 7

#include<stdio.h>

#include<math.h>

int main() {

int x = fabs(-9);

printf(“%d”, x);

return 0;

}

The output will be 9.

Fabs is a floating point function which means it expects the float value in the argument.


abs():- It is part of the stdlib header file. We can use abs() for integer values. The usage would be the same as that of fabs(). We can implement the abs function on our own as well.

You are given two integers. You need to find the absolute difference between both numbers.

#include<stdio.h>

#include<stdlib.h>

int main(){

int x, y;

scanf(“%d %d”, &x, &y);

if(x >= y) {

printf(“%d“, x-y);

} else {

printf(“%d“, y-x);

}

return 0;

}

We can also write this code using the abs() function.

#include<stdio.h>

#include<stdlib.h>

int main() {

int x, y;

scanf(“%d %d”, &x, &y);

printf(“%d”, abs(x - y) );

return 0;

}