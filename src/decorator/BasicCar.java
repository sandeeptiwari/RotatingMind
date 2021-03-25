package decorator;

public class BasicCar implements Car{


    @Override
    public void assembled() {
        System.out.println("all basic features");
    }
}
