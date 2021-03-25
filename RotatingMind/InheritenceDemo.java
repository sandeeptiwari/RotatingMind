package com.test.teggig;


public class InheritenceDemo  extends Test04_B{

	public static void main(String[] args) {
		/*AInherit a = new SubB2();
		try {
			a.foo();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}*/

		/*String csv = "Sue,5,true,3";
		Scanner scanner = new Scanner( csv );
		scanner.useDelimiter(",");
		int age = scanner.nextInt();
		System.out.println(age);*/
		
		InheritenceDemo c = new InheritenceDemo();
		c.m1();

	}

}

class AInherit {
	void foo() throws Exception { throw new Exception(); }
}
class SubB2 extends AInherit {
	void foo() { System.out.println("B "); }
}


class Breaker {
	static String o = "";
	/*public static void main(String[] args) {
		z:
		//	o = o + 2;
	for(int x = 3; x < 8; x++) {
		for (int i = 0; i < args.length; i++) {
			if(x==4) break;
			if(x==6) break z;
			o = o + x;
		}

	}
	System.out.println(o);
	}*/
}



class Test04_B extends Test04_A {

}

class Test04_A {
	public void m1() {
		System.out.println("class A");
	}
}
