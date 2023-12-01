package interview.jvm;

public class StringPoolDemo {
	
	static void stringPool() {
		  System.out.println("\nInside stringPool ...");
		  String s1 = "hello!";
		  String s2 = "hello!";
		  String s3 = "hello!".intern();
		  String s4 = new String("hello!");	 		  
		  String s5 = "lo!"; 
		  
	      System.out.println("s1 == s2: " + (s1 == s2));
	      System.out.println("s1 == s3: " + (s1 == s3));
	      System.out.println("s1 == s4: " + (s1 == s4));
	      System.out.println("s1 == s4.intern(): " + (s1 == s4.intern()));
	      System.out.println("s1 == \"hel\" + \"lo!\": " + (s1 == "hel" + "lo!"));
	      System.out.println("s1 == \"hel\" + s5: " + (s1 == "hel" + s5)); // true if s5 is final!
	      System.out.println("s1 == (\"hel\" + s5).intern(): " + (s1 == ("hel" + s5).intern()));
	      // Above statement demonstrates that only string literals known at compile-time
	      // will be in string pool (unless interned via intern())*/
	}
	
	public static void main(String[] args) {
		stringPool();
	}
}
