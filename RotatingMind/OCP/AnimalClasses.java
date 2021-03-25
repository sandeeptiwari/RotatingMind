package my.sports;

public enum AnimalClasses {
	
	MAMMAL(true), FISH(Boolean.FALSE), BIRD(false), REPTILE(false), AMPHIBIAN(false), INVERTEBRATE(false);
	
	private boolean hasHair;
	
	AnimalClasses(boolean type){
		this.hasHair = type;
	}

}
