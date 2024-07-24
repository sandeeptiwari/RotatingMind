package oops.overriding;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        Animal a = new Cat();
        overriddenDemo(a);
    }

    //overriding:-
    static void overriddenDemo(Animal animal) throws SQLException {
        System.out.println("Noise " + animal.makeNoise());
    }
}
