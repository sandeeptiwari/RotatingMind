package com.sandi.ocp;

public class Book {
	
	private int ISBN;
	private String title, auther;
	private int pageCount;
	
	public int hashCode() {
		return ISBN;
	}
	
	@Override public boolean equals(Object obj) {
		
		if(!(obj instanceof Book)) {
			return false;
		}
		
		Book other = (Book)obj;
		return this.ISBN == other.ISBN;
		
	}

	public static void main(String[] args) {
		
		Book b1 = new Book();
		b1.ISBN = 1001;
		
		Book b2 = new Book();
		b2.ISBN = 1001;
		
		System.out.println(b1.equals(b2));
	}

}
