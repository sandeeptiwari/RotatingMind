package my.sports;

public interface Otter {
	default void play() {}
}

class RiverOtter implements Otter{
	@Override public void play() {}
	
	@Override public int hashCode() {
		return 42;
	}
	
	@Override public boolean equals(Object o) { return false;}
}
