package oops.overriding;

public class Main {

    public static void main(String[] args) {
        Animal a = new Cat();
        overriddenDemo(a);
    }

    //overriding:-
    static void overriddenDemo(Animal animal) {
        System.out.println("Noise " + animal.makeNoise());
    }
}
