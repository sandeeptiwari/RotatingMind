package com.test.teggig;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

	static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    } 
	
	public void checkMap(){
		Map<MapPerson, Integer> map = new HashMap<MapPerson, Integer>();
		
		MapPerson p = new MapPerson(1, "A", 21);
		MapPerson p1 = new MapPerson(1, "A", 21);
		MapPerson p2 = new MapPerson(1, "A", 21);
		MapPerson p3 = new MapPerson(1, "A", 2);
		
		/*MapPerson p = new MapPerson(1, "A", 23);
		MapPerson p1 = new MapPerson(4, "C", 24);
		MapPerson p2 = new MapPerson(23, "B", 25);
		MapPerson p3 = new MapPerson(2, "D", 26);*/
		
		System.out.println("p "+p.hashCode()+" hash "+hash(p));
		map.put(p, 1);
		System.out.println("p1 "+p1.hashCode()+" hash "+hash(p1));
		map.put(p1, 10);
		System.out.println("p2 "+p2.hashCode()+" hash "+hash(p2));
		map.put(p2, 100);
		System.out.println("p3 "+p3.hashCode()+" hash "+hash(p3));
		map.put(p3, 1000);
		
		System.out.println("size "+map.size());
		
		System.out.println("map = "+map);
	}

	public static void main(String[] args) {
		HashMapDemo demo = new HashMapDemo();
		demo.checkMap();
	}

}

class MapPerson{
	private int id;
	private String name;
	private int age;



	public MapPerson(int id, String name, int age) {
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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		/*if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MapPerson other = (MapPerson) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;*/
		return false;
	}
	
	/*@Override
	public int hashCode() {
		return 0;
	}*/
	
	
}