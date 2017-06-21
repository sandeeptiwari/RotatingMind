/*
 * 1)	The constructor of enum in java must be private any other access modifier will result in compilation error. Now to get the value associated with each coin you can define a
 * 		public getValue() method inside Java enum like any normal Java class. Also, the semicolon in the first line is optional.
 * 2)	Enum constants are implicitly static and final and can not be changed once created. For example, below code of java enum will result in compilation error:
 *		
 * 		Currency.PENNY = Currency.DIME; (The final field EnumExamples.Currency.PENNY cannot be reassigned.)
 *
 * 3)Java compiler automatically generates static values() method for every enum in java. Values() method returns array of Enum constants in the same order they have listed in 
 *        Enum and you can use values() to iterate over values of Enum  in Java as shown in below example:
 *
 *		for(Currency coin: Currency.values()){
 *			System.out.println("coin: " + coin);
 *		}
 *  Notice the order is exactly the same as defined order in the Enum.
 *	And it will print:
 *	coin: PENNY
 *	coin: NICKLE
 *	coin: DIME
 *	coin: QUARTER
*/
public class JavaEnumConstructor{

}

public enum Currency { 
	PENNY(1), NICKLE(5), DIME(10), QUARTER(25); 
	private int value; 
	private Currency(int value) {
		this.value = value; 
		}
};