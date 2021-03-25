package stream_advance.flatten;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class City {
    private String name;
    private List<Person> peoples = new ArrayList<>();

    public City() {
    }

    public City(String name, Person... people) {
        this.name = name;
        this.peoples.addAll(Arrays.asList(people));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPeoples() {
        return peoples;
    }

    public void setPeoples(List<Person> peoples) {
        this.peoples = peoples;
    }
}
