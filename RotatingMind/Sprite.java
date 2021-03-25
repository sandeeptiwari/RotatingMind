package com.test.teggig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

interface A{
	//public void doSomething(String str);
	public String toString();
}

class AImpl implements A{

	/*@Override
	public void doSomething(String str) {
		// TODO Auto-generated method stub

	}*/

}

class B{
	B(){
		System.out.println("Atom");
	}
	public A doIt(){
		return new AImpl();
	}

	public Object execute(){
		return "";
	}
}

class C extends B{

	C(String str){
		System.out.println(str);
	}
	public AImpl doIt(){
		return new AImpl();
	}

	public String execute(){//object not allowed
		return "";
	}
}

class D extends C{
	D(){
		super("Granite");
		new C("Granite");
	}
}

class Nav{
	enum Direction {EAST, WEST, NORTH, SOUTH}
	enum MyColor {RED(0xff0000), GREEN(0x00ff00), BLUE(0x0000ff);
	private final int rgb;
	MyColor(int rgb) { this.rgb = rgb; }
	public int getRGB() { return rgb; }
	}
	/*public static void main(String[]... a) {
		MyColor treeColor = MyColor.GREEN;
	}*/
}

class Building { }

public class Sprite extends Building{
	Nav.Direction d = Nav.Direction.EAST;
	//private final int x;
	/*Sprite(int x1){
		x = x1;
	}*/

	public void go() {
		String o = "";
		z:
			for(int x = 0; x < 3; x++) {
				for(int y = 0; y < 2; y++) {
					if(x==1) break;
					if(x==2 && y==1) break z;
					o = o + x + y;
				}
			}
		System.out.println(o);
	}

	public static void main(String...args){
		boolean b1 = false;
		/*if((b1 = true)){
			System.out.println("true");
		}*/
		//new Sprite(10);
		//new Sprite(11);
		//new D();

		/*System.out.println(new A(){

			public String toString(){
				return "test";
			}
		});*/

		/*Building build1 = new Building();
		Sprite barn1 = new Sprite();
		Sprite barn2 = (Sprite) build1;//class cast exception
		Object obj1 = (Object) build1;
		//String str1 = (String) build1;
		Building build2 = (Building) barn1;
		System.out.println("OK");*/

		//System.out.print(new Yen().getC() + " " + new Euro().getC());

		//new Boxer1(new Integer(4));

		//new Person("Ram");

		//new Batman();

		/*Icelandic i1 = new Icelandic();
		Icelandic i2 = new Icelandic();
		Icelandic i3 = new Icelandic();

		System.out.println(i3+" -- "+i1+" -- "+i2);

		i3 = i1; i1 = i2; i2 = null; i3 = i1;

		System.out.println(i3+" -- "+i1+" -- "+i2);*/

		//String[] elements = { "for", "tea", "too" };
		//String first = (elements.length > 0) ? elements[0] : null;
		
		
		
	}
}






class SuperCalc {
	protected static int multiply(int a, int b) { return a * b;}
}

class SubCalc extends SuperCalc{
	public static int multiply(int a, int b) {
		int c = 0;//super.multiply(a, b);// cant use super in static context
		return c;
	}
}

class Money {
	//private then compilation error
	public String country = "Canada";
	public String getC() { return country; }
}
class Yen extends Money {
	public String getC() { return super.country; }
}
class Euro extends Money {
	public String getC(int x) { return super.getC(); }
	//public static void main(String[] args) {

	//}
}

class Boxer1{
	Integer i;
	int x;
	public Boxer1(int y) {
		x = i+y;
		System.out.println(x);
	}

}

class Person {
	private String name;
	public Person(String name) { this.name = name; 

	/*Object [] myObjects = {
			new Integer(12),
			new String("foo"),
			new Integer(5),
			new Boolean(true)
	};*/
	List l = new ArrayList();
	l.add(12);
	l.add("foo");
	l.add(5);
	l.add(true);
	Collections.sort(l);

	for (int i = 0; i < l.size(); i++) {
		System.out.println(l.get(i));
	}
	//Arrays.sort(myObjects);
	/*for(int i=0; i<myObjects.length; i++) {
		System.out.print(myObjects[i].toString());
		System.out.print(" ");
	}*/

	}

	/*public boolean equals(Person p) {
		return p.name.equals(this.name);
	}*/

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}
}

class Score implements Comparable<Score> {

	public void m1(){
		m1();
	}

	public void m2(){

	}

	@Override
	public int compareTo(Score arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}


class Batman {
	int squares = 81;
	/*public static void main(String[] args) {
		new Batman().go();
	}*/
	void go() {
		incr(++squares);
		System.out.println(squares);
	}
	void incr(int squares) { squares += 10; }
}

interface Animal { void makeNoise(); }
class Horse implements Animal {
	Long weight = 1200L;
	public void makeNoise() { System.out.println("whinny"); }
}

class Icelandic extends Horse {
	public void makeNoise() { System.out.println("vinny"); }

}