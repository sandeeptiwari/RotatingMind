// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
public class FibonacciCalcii{

 public static void printFabonacci(int n){
    int a = 0, b = 1, c = 0;
	for(int i = 0; i < n; i++){
		c = a + b;
		a = b;
		b = c;
		
		System.out.print(c+" ");
	}
 }
 
public static int fibonacci(int n)
{
	if (n <= 1)
		return n;
	return fibonacci(n - 1) + fibonacci(n - 2);
}

 public static void main(String args[]){
	 System.out.print(fibonacci(45)+" ");
	//printFabonacci(5);
 }
}