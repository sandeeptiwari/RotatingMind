//0, 1, 1, 2, 3, 5, 8, 13, 21, 34

public class FabnaciiSeriese{
	
	public void printSeriese(int limit){
		int a = 0, b = 0, c = 1;
		System.out.print(0+" ");
		while(limit > 0){
			a = b + c;
			b = c;
			c = a;
			
			System.out.print(a+" ");
			limit--;
		}
		
	}
	
	public void printFibnaciiRecursively(){
		
	}
	
	
	public static void main(String...args){
		FabnaciiSeriese sereise = new FabnaciiSeriese();
		sereise.printSeriese(13);
	}
}