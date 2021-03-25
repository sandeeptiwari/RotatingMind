package decorator;

public class SportCar extends CarDecorator {

    public SportCar(Car c) {
        super(c);
    }

    @Override
    public void assembled() {
        super.assembled();
        System.out.println("new Features");
    }
}
