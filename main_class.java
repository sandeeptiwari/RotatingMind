class  main_class {
  int x = 9;
  
  public void show(){
      if(x == 9){
	      int x = 8;
		  System.out.println(x);
	  }
  }
  public static void main(String...args){
      main_class main = new main_class();
	  main.show();
  }
}
