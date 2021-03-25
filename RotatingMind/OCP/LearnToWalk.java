package my.sports;

public class LearnToWalk {
	
	public void toddle() {
		System.out.println("LearnToWalk");
	}
	
	class BabyRhino extends LearnToWalk{
		
		public final void toddle() {
			System.out.println("BabyRhino");
		}
	}
	
	public static void main(String...args) {
		
		LearnToWalk baby = new LearnToWalk().new BabyRhino();
		
		baby.toddle();
	}

}
