package com.test.teggig;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
	
	public void traverse(){
		List<TestPerson> persons = new ArrayList<>();
		
		TestPerson p0 = new TestPerson(1, "A", 21);
		TestPerson p1 = new TestPerson(1, "A", 21);
		TestPerson p2 = new TestPerson(1, "A", 21);
		TestPerson p3 = new TestPerson(1, "A", 21);
		
		/*TestPerson p2 = new TestPerson(2, "B", 35);
		TestPerson p3 = new TestPerson(3, "C", 25);*/
		
		persons.add(p0);
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		
		System.out.println(persons.size());
		
		//for(TestPerson p : persons){
		for (int i = 0; i < persons.size(); i++) {
			TestPerson p = persons.get(i);
			if(p.getAge() == 25)
			{
				persons.remove(p);
			}
			else if(p.getAge() > 35){
				persons.add(new TestPerson(4, "D", 40));
			}
		}
		System.out.println(persons.size());
	}
	
	public static void main(String...args){
		ListDemo demo = new ListDemo();
		demo.traverse();
	}

}


class TestPerson{
	private int id;
	private String name;
	private int age;
	
	public TestPerson(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
}