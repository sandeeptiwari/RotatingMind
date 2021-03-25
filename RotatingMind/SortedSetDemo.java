import java.util.*;

public class SortedSetDemo{
	public static void main(String[] args){
		
		TreeSet t = new TreeSet();
		Person p1 = new Person("Ramesh", 21);
		Person p2 = new Person("Dhanesh", 23);
		Person p3 = new Person("Suresh", 19);
		Person p4 = new Person("Jhon", 34);
		
		t.add(p1);
		t.add(p2);
		t.add(p3);
		t.add(p4);
		
		Iterator itr = t.iterator();
		while(itr.hasNext()){
			Person p = (Person)itr.next();
			System.out.println(p.getName()+"\t");
		}
	 
	}

}

class Person implements Comparable{
	private String name;
	private int age;
	
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	
	@Override
	public int compareTo(Object o){
		return (this.age - ((Person)o).getAge()); 
	}
}