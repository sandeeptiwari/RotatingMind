import java.util.*;
import java.util.function.Function;

public class DifferentMapDemo {

    public static void main(String...args){
        Map<EmployeeKey, Integer> map = new HashMap<>();
        map.put(null, 23);
        map.put(new EmployeeKey(1001, "Sandeep Tiwari"), 24);

        List<EmployeeKey> keys = new ArrayList<>();
        keys.add(new EmployeeKey(1001, "Sandeep Tiwari"));
        keys.add(new EmployeeKey(1002, "Rahul Tiwari"));
        keys.add(new EmployeeKey(1003, "Dinesh Tiwari"));
        keys.add(new EmployeeKey(1004, "Mukesh Tiwari"));

        //keys.stream().collect(HashMap::new, (k, v) -> k.put(Function.identity(), v.getId()), (k, v) -> k.put(Function.identity(), v.getId()));
    }
}

final class EmployeeKey{

    private final int id;
    private final String name;

    public EmployeeKey(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeKey that = (EmployeeKey) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
