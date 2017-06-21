import java.util.*;
public class TreeSetDemo{
	public static void main(String[] args){
		
		TreeSet t = new TreeSet();
		t.add("A");
		t.add("a");//bigger than 97
		t.add("B");
		t.add("Z");
		t.add("L");
		//t.add(new Integer(10));//CCE
		//t.add(null);//---NPE
		System.out.println(t);//[A, B, L, Z, a]
			 
	}

}