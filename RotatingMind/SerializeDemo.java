package com.test.teggig;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//System.out.println("Serialization...");
		/*FileOutputStream fos = new FileOutputStream("test.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new Dog());*/
		
		/*System.out.println("DeSerialization...");
		FileInputStream fis = new FileInputStream("test.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Dog d = (Dog)ois.readObject();
		System.out.println(d.i);*/
		//System.out.println(d.a.d);
		
		String s = "-";
		Integer x = 343;
		long L343 = 343L;
		if(x.equals(L343)) s+=".e1";
		if(x.equals(343)) s+=".e2";
		
		Short s1 = (short)((new Short((short)343))/(new Short((short)49)));
		
		if(s1 == 7) s += "=s ";
		if(s1 < new Integer(7 + 1)) s += "fly ";
		
		System.out.println(s);
	}

}


class AnimalTest{
	public int d = 20;
	AnimalTest(){
		System.out.println("A");
	}
}

class Dog  implements Serializable{
	public int i = 10;
	public AnimalTest a;
	Dog(){
		System.out.println("D");
		a = new AnimalTest();
		System.out.println(a.d);
	}
}
