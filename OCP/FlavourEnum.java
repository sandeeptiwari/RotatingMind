package com.sandi.ocp;

public class FlavourEnum {
	
	enum Flavours{
		VANILLA, CHOCOLATE, STRAWBERRY
	}

	public static void main(String[] args) {
		
		System.out.println(FlavourEnum.Flavours.CHOCOLATE.ordinal());
		
		Flavours f = Flavours.STRAWBERRY;
		
		// not compiled
		switch(f) {
		/*case 0: System.out.println("vanilla");
		case 1: System.out.println("vanilla");
		case 2: System.out.println("vanilla");
		 break;*/
		 default : 
			 System.out.println("missing flavour");
		
		}

	}

}
