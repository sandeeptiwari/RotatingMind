package hashmap;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapStudy {

    private void capacityAndSize(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        System.out.println("Size "+map.size());
        try {
            getCapacity(map);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void getCapacity(HashMap m ) throws NoSuchFieldException, IllegalAccessException {
        Field tableField = HashMap.class.getDeclaredField("table");
        tableField.setAccessible(true);
        Object[] table = (Object[]) tableField.get(m);
        System.out.println(table == null ? 0 : table.length);
    }

    public static void main(String...args){
        HashMapStudy hashMapStudy = new HashMapStudy();
        //hashMapStudy.capacityAndSize();

        HashMap<Employee, String> map = new HashMap<>();

        Employee e1 = new Employee(1, "A");
        putIn(map, e1, "MS");
                 e1 = new Employee(1, "A");
        Employee e2 = new Employee(2, "B");
        Employee e3 = new Employee(3, "C");
        Employee e4 = new Employee(4, "D");


        putIn(map, e1, "TCS");
        putIn(map, e2, "INTEL");
        putIn(map, e3, "IBM");
        putIn(map, e4, "FB");

        System.out.println("Map is => "+map);

        System.out.println("Size of Map "+map.size());

        Employee e111 = new Employee(1, "A");

        System.out.println("A is working in "+map.get(e1));
    }


    public static void putIn(Map<Employee, String> map, Employee key, String value){
        System.out.println("hashcode OF "+key.getName()+" is ==  "+Objects.hash(key));
        map.put(key, value);
    }

}


class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     *  Only the references to the same(==) object will return true. In other words, those objects you expected to be equal
     *  will not be equal by calling the equals method
     * @return
     */
   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(name, employee.name);
    }

    /**
     * There might be duplicates in the HashMap or HashSet. We write the equals method and expect{"abc", "ABC"} to be
     * equals. However, when using a HashMap, they might appear in different buckets, thus the contains()
     * method will not detect them each other
     * @return
     */
    /*@Override
    public int hashCode() {
        return Objects.hash(id, name);
    }*/
}
