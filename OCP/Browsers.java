package my.sports;

public class Browsers {

	static class Browser{

		public void go() {
			System.out.println("Inside browser");
		}
	}

	static class FireFox extends Browser{

		public void go() {
			System.out.println("Inside Firefox");
		}
	}

	static class IE extends Browser{

		@Override public void go() {
			System.out.println("Inside IE");
		}
	}
	public static void main(String[] args) {
		
		Browser b = new FireFox();
		IE e = (IE) b;
		e.go();

	}

}
