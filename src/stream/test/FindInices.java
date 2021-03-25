package stream.test;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindInices {
    /*
     * List=[10,200,30,150,400,30]
     * expect result=[1,3,4]
     */
    public List<Integer> findIndices(List<Person> persons) {
       //1-
       List<Integer> indices = persons.stream()
               .filter(person -> person.getAge() > 40)
               .map(ele -> persons.indexOf(ele))
               .collect(Collectors.toList());

        IntPredicate  p = index -> persons.get(index).getAge() > 40;
       //2-
        List<Integer> indices1= IntStream.range(0, persons.size())
                .filter(p)
                .boxed()
                .collect(Collectors.toList());


        //https://stackoverflow.com/questions/60349544/how-to-customize-map-merge-with-executor-submit
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < persons.size(); i++) {
            map.merge(persons.get(i).getName(), String.valueOf(persons.get(i).getAge()), String::concat);
        }
        System.out.println("Map==> "+map);
        return indices;
    }

    public static void main(String[] args) {
        FindInices inices = new FindInices();

        Person p1 = new Person("A", 21);
        Person p2 = new Person("A", 51);
        Person p3 = new Person("C", 44);
        Person p4 = new Person("C", 98);
        Person p5 = new Person("E", 29);
        Person p6 = new Person("F", 91);
        Person p7 = new Person("G", 62);
        Person p8 = new Person("H", 49);
        Person p9 = new Person("I", 35);
        Person p10 = new Person("J", 99);

        List<Person> list = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
        System.out.println("Search Result at : "+inices.findIndices(list));
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
