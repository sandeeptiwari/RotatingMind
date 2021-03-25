
interface Interface1
{
	final static String MSG = "Java Programming Skills";
}

interface Interface2 extends Inteface1
{
	final static String MSG = "Java";
	void display();
}

interface Interface3 extends Interface1, Interface2
{
	void display();
}


public class Test implements Inteface1, Inteface2{
	
	public static void swap(Integer i, Integer j){
		Integer temp = new Integer(i);
		i=j;
		j=temp;
	}

	public static void main(String args[]){
		
		//Integer i = new Integer(10);
		//Integer j = new Integer(20);
		//swap(i, j);
		//System.out.println("i = "+i+" j= "+j);
		 
		//Example example = new Example("test");
     Inteface2 inteface2 = new Test();
	 inteface2.display();
 }
 
 @Override
 public void display(){
	System.out.println(MSG); 
 }

 
}
