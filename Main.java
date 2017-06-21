abstract class main_abstract{
  int i;
  abstract void display();
}

class A extends main_abstract{
   int j;
   void display(){
     System.out.println("Check"+j);
   }
}

class Main{
   public static void main(String...args){
      A obj = new A();
	  obj.j = 2;
      obj.display();
   }
}