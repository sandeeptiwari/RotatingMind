package stream_advance.flatten;

import java.util.List;

public class FlattenDemo {

    public static void main(String[] args) {
        Person p1 = new Person("Paul", 25);
        Person p2 = new Person("Sarah", 27);
        Person p3 = new Person("James", 31);
        Person p4 = new Person("Julie", 25);
        Person p5 = new Person("Charles", 22);
        Person p6 = new Person("Charlotte", 31);
        Person p7 = new Person("Ann", 27);
        Person p8 = new Person("Boris", 29);
        Person p9 = new Person("Emily", 34);

        City newYork = new City("New York", p1, p2, p3);
        City paris = new City("New York", p4, p5, p6);
        City london = new City("New York", p7, p8, p9);

        List<City> cities = List.of(newYork, paris, london);

        var count = cities.stream()
                .flatMap(city -> city.getPeoples().stream())
                .count();
        System.out.println("Number of people in all cities " + count);
    }
}
