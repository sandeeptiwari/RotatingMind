import java.math.BigDecimal;

public class EffectiveJavaPuzzle{
	
	public void puzzle1(){
		System.out.println(2.00 - 1.00);
		
		//System.out.println("%.2f%n", 2.00 - 1.00);
		BigDecimal nom1 = new BigDecimal("2.00");
		BigDecimal nom2 = new BigDecimal("1.00");
		System.out.println(nom1.subtract(nom2));
	}
	
	public void puzzle2(){
		System.out.println(12345 + 54321L);//always use a capitel L in long literals, never a lowercase l
	}
	
	/*
	 *  when working with large numbers,
	 *	watch out for overflow - it’s a silent killer
	*/
	public void puzzle3(){
		final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
		final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
		System.out.println("BEFORE MILLI "+MICROS_PER_DAY / MILLIS_PER_DAY);
		
		// computation of constant overflows!
		long MICROS_PER_DAY1 = ((int) (24 * 60 * 60 * 1000 * 1000));
		// afterwards widening primitive conversion [JLS 5.1.2]
		//final long MICROS_PER_DAY1 = 24L * 60 * 60 * 1000 * 1000;
		final long MILLIS_PER_DAY1 = 24L * 60 * 60 * 1000;
		System.out.println("AFTER MILLI "+MICROS_PER_DAY1 / MILLIS_PER_DAY1);
	}
	
	/*
     * do not use compound assignment operators
	 * on variables of type byte, short or char
     * Monday,	
	*/
	public void puzzle4(){
		short x = 0;
		int i = 123456;
		x += i; // narrowing primitive conversion [JLS 5.1.3]
		//x = x + i; // wont compile:possible loss of precision
		System.out.println("Value of x "+x);
	}
	
	/*
     * 1. left-hand side object reference type != String
	 * 2. is assignment compatible JLS 5.2
	 * 3. string concatenation is performed JLS 15.26.2	
	*/
	public void puzzle5(){
		Object x = "object string";
		String i = "real string";
		x += i;
		x = x + i;
		System.out.println("Value of x "+x);
	}
	/*
	 * do not use Unicode escapes to represent ASCII characters;
	 * avoid Unicode escapes except where they are truly necessary
	*/
	public void puzzle6(){
		
		System.out.println("a.length() + b".length());
		
		// \u0022 is the unicode escape for double quote (")
		System.out.println("a\u0022.length() + \u0022b".length());
		
		// bellow is Unicode representation of linefeed (LF)
		char c = 0x000A;
		//System.out.println(c);
	}
	
	public void puzzle7(){
		
	}
	
	public static void main(String...args){
		EffectiveJavaPuzzle puzzles = new EffectiveJavaPuzzle();
		//puzzles.puzzle1();
		//puzzles.puzzle2();
		//puzzles.puzzle3();
		//puzzles.puzzle4();
		//puzzles.puzzle5();
		//puzzles.puzzle6();
		puzzles.puzzle7();
	}
}