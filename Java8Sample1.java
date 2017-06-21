import java.util.stream.IntStream;

public class Java8Sample1
{

 public boolean isPrime(int number){
	 /*for(int i = 2; i < number; i++){
		 if(number % i == 0){
			 return false;
		 }
	 }*/
	 return number > 1 &&
				IntStream.range(2, number)
					.noneMatch(index -> number % index == 0);
 }
 
 public static void main(String...args){
	Java8Sample1 java8Sample1 = new Java8Sample1();
	System.out.println(java8Sample1.isPrime(5));
	System.out.println(java8Sample1.isPrime(1));
	System.out.println(java8Sample1.isPrime(2));
	System.out.println(java8Sample1.isPrime(3));
	System.out.println(java8Sample1.isPrime(7));
	System.out.println(java8Sample1.isPrime(11));
 }
}