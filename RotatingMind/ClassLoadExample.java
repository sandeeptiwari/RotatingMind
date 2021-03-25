import java.lang.reflect.*;
public class ClassLoadExample{


  public static void main(String...args)throws Exception{
	  Class c = Class.forName("Student");//java.lang.Object
	  
	  System.out.println(c.getDeclaredMethods()[0]);
  }

}

class Student{
	
	public String getName(){
		return "Sandeep Tiwari";
	}
	
	public long getRollNo(){
		return 23013245l;
	}
}