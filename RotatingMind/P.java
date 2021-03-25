import java.io.*;
class C{
	static int x = 10;
	static int y = 6;
    /*public  void m1(int i)throws IOException
	{
		//System.out.print("p");
	}*/
	
  
}

class A extends C{
	static {
	   y = 10;
	  System.out.print(y);
  }
  
  
}

public class P{
	//int x = 888;
  /*public  void m1(int i)//throws FileNotFoundException
  {
	 // System.out.print("c"+x);
	 x = 888;
	 System.out.print("c "+x);
  }*/
  static {
	   y = 10;
	  System.out.print(y);
  }
  
  public static void main(String args[])
  {
	 // C p = new C();
	 // A.print();  
  }
}
