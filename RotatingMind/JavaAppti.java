package com.test.teggig;

import java.util.Collections;
import java.util.List;

public class JavaAppti {
	
	public void callBy(int i, int j){
		i/=2;
		j*=2;
	}

	public void incrementOperator(){
		int i = 0;
		while(true){
			System.out.println("0 "+i);
			if(i++ == 4){
				break;
			}
			System.out.println("1 "+i);
			++i;
			System.out.println("2 "+i);
		}
		System.out.println(i);
	}
	
	
	public void updateList(List<String> strList){
		//strList.set(2, "c");
		Collections.sort(strList);
	}
	
	public static void main(String[] args) {
		JavaAppti javaAppti = new JavaAppti();
		System.out.println((int)'a');
		//javaAppti.incrementOperator();
		/*1 - int a = 20, b = 40;
		System.out.println("a = "+a+" b "+b);
		javaAppti.callBy(a, b);
		System.out.println("a = "+a+" b "+b);
		*/
		
		/*List<String> strList = new ArrayList<String>();
		strList.add("a");
		strList.add("b");
		strList.add("#");
		strList.add("d");
		strList.add("e");
		javaAppti.updateList(strList);
		System.out.println(strList);*/
		
		/*List strList = new ArrayList();
		strList.add("9");
		strList.add("2");
		strList.add("40");
		strList.add("5");
		strList.add("4");
		javaAppti.updateList(strList);
		System.out.println(strList);
		*/
	}

}
