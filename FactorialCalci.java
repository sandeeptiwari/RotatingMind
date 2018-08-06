import java.util.stream.Stream;
import java.util.stream.IntStream;

public class FactorialCalci{
	
	
	
	public static void main(String...args){
		//System.out.println(IntStream.rangeClosed(2, 5).forEach(x -> System.out.println(x)));//.reduce(1, (x, y) -> x*y));
		
		//rangeClosed method will generate number from given value (2)
		// top last value (5 ) in bello it will genearet 2, 3, 4, 5
		IntStream.rangeClosed(2, 5).forEach(x -> System.out.println(x));
		System.out.println(IntStream.rangeClosed(2, 5).forEach(x -> System.out.println(x)));
	}
}