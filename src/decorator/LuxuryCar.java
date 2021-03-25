package decorator;

public class LuxuryCar extends CarDecorator {

    public LuxuryCar(Car c) {
        super(c);
    }

    @Override
    public void assembled() {
        super.assembled();
        System.out.println("luxery features");
    }
}
