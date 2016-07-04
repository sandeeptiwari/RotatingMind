/*
 *  You have a function rand5() that generates a random integer from 1 to 5. Use it to write a function rand7() that generates a random integer from 1 to 7.
 *	rand5() returns each integer with equal probability. rand7() must also return each integer with equal probability.
*/
import java.util.Random;
public class RandomGenerator{
	
	
	public int rand5(){
		  Random random = new Random();
		  return random.nextInt(5);
	}
	
	public int rand7()
	{
		return ((2 * rand5())%7 + 1);
	}
	
	public static void main(String...args){
		RandomGenerator generate = new RandomGenerator();
		for(int i = 0; i < 15; i++){
			System.out.println("random : "+generate.rand7());
		}
	}
}