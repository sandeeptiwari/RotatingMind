package stream.designpattern.factory;

import java.util.List;
import java.util.function.Supplier;

public class PlayWithFactory {

    public static void main(String[] args) {

        //CircleFactory factory = () -> new Circle();
         Factory<Circle> factory = () -> new Circle();

        Circle circle = factory.get();

        System.out.println("Circle "+circle);

        Circle circle1 = factory.newInstance();

        System.out.println("Circle "+circle1);

        List<Circle> circleList = factory.create5();

        System.out.println("Circle "+circleList);

        Factory<Circle> factory1 = Factory.createFactory(Circle::new);
        System.out.println("Hashcode1-> "+factory1.get().hashCode());
        System.out.println("Hashcode2-> "+factory1.get().hashCode());
        System.out.println("Hashcode3-> "+factory1.get().hashCode());
    }
}
