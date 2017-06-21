public class TwoNearestNumberFrom100{

	public int getNearestFrom100(int input1, int input2){
		if(input1 == input2)
			return input1;
		else
			return (Math.abs(100 - input1) - Math.abs(100 - input2)) > 0 ? input2 : input1;
		
	}
	public static void main(String...args){
		TwoNearestNumberFrom100 nearestFrom100 = new TwoNearestNumberFrom100();
		int res = nearestFrom100.getNearestFrom100(99, 102);
		System.out.print("Result : "+res);
	}
}
9278286919