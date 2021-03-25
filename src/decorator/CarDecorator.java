package decorator;

public class CarDecorator implements Car{

    private Car c;
    public CarDecorator(Car c){
        this.c = c;
    }

    @Override
    public void assembled() {
        this.c.assembled();
    }
}
