package stream.designpattern.comparator;

import stream.designpattern.Comparator;
import stream.designpattern.Function;
import stream.designpattern.model.Person;

public class ComparatorDemo {

    public static void main(String[] args) {

        Person mary = new Person("Mary", 28);
        Person john = new Person("John", 22);
        Person linda = new Person("Linda", 26);
        Person james = new Person("James", 32);
        Person jamesBis = new Person("James", 26);

        Function<Person, String> getName = p -> p.getName();

        Comparator<Person> personNmComp = (p1, p2) -> {
            /*String name1 = p1.getName();
            String name2 = p2.getName();*/
            String name1 = getName.apply(p1);
            String name2 = getName.apply(p2);
            return name1.compareTo(name2);
        };

        System.out.println("Mary > John : " + (personNmComp.compare(mary, john) > 0));
        System.out.println("John > James : " + (personNmComp.compare(john, james) > 0));
        System.out.println("James > linda : " + (personNmComp.compare(james, mary) > 0));

        System.out.println("\n------------------------------------------------------------------- \n");
        Comparator<Person> cmpName = Comparator.comparing(Person::getName);
        Comparator<Person> cmpAge = Comparator.comparing(Person::getAge);

        System.out.println("Mary > John : " + (cmpName.compare(mary, john) > 0));
        System.out.println("John > James : " + (cmpName.compare(john, james) > 0));
        System.out.println("James > linda : " + (cmpName.compare(james, linda) > 0));

        System.out.println("\n------------------------------------------------------------------- \n");
        System.out.println("Mary > John : " + (cmpAge.compare(mary, john) > 0));
        System.out.println("John > James : " + (cmpAge.compare(john, james) > 0));
        System.out.println("James > linda : " + (cmpAge.compare(james, linda) > 0));

        System.out.println("\n------------------------------------------------------------------- \n");

        Comparator<Person> reverseCmpName = cmpName.reversed();

        System.out.println("Mary > John : " + (reverseCmpName.compare(mary, john) > 0));
        System.out.println("John > James : " + (reverseCmpName.compare(john, james) > 0));
        System.out.println("James > linda : " + (reverseCmpName.compare(james, linda) > 0));

        System.out.println("\n------------------------------------------------------------------- \n");

        Comparator<Person> cmpNameThenAge = cmpName.thenComparing(cmpAge);
        System.out.println("Mary > John : " + (cmpNameThenAge.compare(mary, john) > 0));
        System.out.println("John > James : " + (cmpNameThenAge.compare(john, james) > 0));
        System.out.println("James > linda : " + (cmpNameThenAge.compare(james, linda) > 0));
        System.out.println("James > James Bis : " + (cmpNameThenAge.compare(james, jamesBis) > 0));

        System.out.println("\n------------------------------------------------------------------- \n");

        Comparator<Person> cmp = Comparator.comparing(Person::getName)
                .thenComparing(Person::getAge);
        System.out.println("Mary > John : " + (cmp.compare(mary, john) > 0));
        System.out.println("John > James : " + (cmp.compare(john, james) > 0));
        System.out.println("James > linda : " + (cmp.compare(james, linda) > 0));
        System.out.println("James > James Bis : " + (cmp.compare(james, jamesBis) > 0));

    }


}
