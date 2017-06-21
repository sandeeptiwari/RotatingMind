class Pair<X, Y>{
	private X first;
	private Y second;
	
	
	public Pair(X first, Y second){
		this.first = first;
		this.second = second;
	}
	public void setValues(Pair<?, ?> pair){
		 System.out.println("pair.Second : "+pair.getSecond());
	}
	
	public X getFirst(){
		return first;
	}
	
	public Y getSecond(){
		return second;
	}
}

public class TestGenerics1{
	
	public static void main(String...args){
		 //--------------------------- 1 --------------------------------
			  /*Pair<String, Integer> pair = new Pair<String, Integer>("First", 2);
			 int second = pair.getSecond();
			 System.out.println("second : "+second);*/
		 //-------------------- 2 -----------------------------------
			  Pair<?, ?> pair = new Pair<String, Long>("First", 2898L);
			  //pair.setValues(pair);
			  long second = pair.getSecond();
			  System.out.println("second : "+second);
	}
}