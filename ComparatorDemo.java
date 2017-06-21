import java.util.*;
public class ComparatorDemo{
	public static void main(String[] args){
		ComparatorDemo cmp = new ComparatorDemo();
		cmp.sort();
	}
	public void sort(){
		TreeSet t = new TreeSet(cptr);
		t.add(10);
		t.add(0);//bigger than 97
		t.add(15);
		t.add(5);
		t.add(20);
		t.add(20);
		System.out.println(t);//[20, 15, 10, 5, 0]
	}
	
	Comparator cptr = new Comparator(){
		public int compare(Object o1, Object o2){
			return -(((Integer)o1) - ((Integer)o2));
		}
	};

}
-------------------------------------------
Q. condition class in concurrent ?
Q2- 7KKKJ

