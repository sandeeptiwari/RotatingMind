package my.sports;

public class Swimmer {

	enum AnimalClasses{
		MAMMAL {
			@Override
			public boolean hasFins() {
				return false;
			}
		}, FISH{
			public boolean hasFins() {
				return true;
			}
		},
		BIRD {
			@Override
			public boolean hasFins() {
				return false;
			}
		}, REPTILE {
			@Override
			public boolean hasFins() {
				return false;
			}
		}, AMPHIBIAN {
			@Override
			public boolean hasFins() {
				return false;
			}
		}, INVERTEBRATE {
			@Override
			public boolean hasFins() {
				return false;
			}
		};
		
		public abstract boolean hasFins();
	}
	
	public static void main(String[] args) {

		
	}

}
