package generic;

import interview.jvm.User;

import java.util.ArrayList;
import java.util.List;

class Person {

}

class Employee extends Person {

    private List<Person> p;

    public void addAll(List<Person> p) {
        this.p = p;
    }

}


public class Concept1 {


    public <T> void main() {

        List<? extends Number> a = new ArrayList<>();
    }

}
