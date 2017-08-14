package com.test.teggig;

public class Test06_C extends Test06_B{

	public void display() {
		System.out.println("Class C");
	}

	public static void main(String[] args) {
		Test06_C testC = new Test06_C();
		Test06_B b = testC;
		b.display();

	}
}

class Test06_B extends Test06_A {
	public void display() {
		System.out.println("Class B");
	}
}
class Test06_A {
	public void display() {
		System.out.println("Class A");
	}

}

/*class Animal1 {}

class Dog extends Animal1 {}
 
class Cat extends Animal1 {}
 
class Test
{
    public static void main(String[] args)
    {
        Animal1 a = new Animal1();
        Dog d = new Dog();
 
        Animal1 a2 = d; // OK, since Dog IS-A Animal
        //Dog d2 = a; // not OK; what if a is a Cat?
    }
}*/