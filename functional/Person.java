package com.sandi.sample1;

public class Person {

	private String name;
	private Gender gender;
	private int age;
	
	public Person(String name, Gender gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}
	
	
	
	
}
