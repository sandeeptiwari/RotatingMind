package decorator;

public class TestDecorator {

    public static void main(String...args){
        SportCar car =new SportCar(new BasicCar());
        //car.assembled();

        LuxuryCar luxuryCar = new LuxuryCar(new SportCar(new BasicCar()));
        luxuryCar.assembled();
    }
}
