import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedularDemo {

    public static void main(String...args){
        /*ExecutorService setrvice = Executors.newSingleThreadScheduledExecutor();
        ((ScheduledExecutorService) setrvice).scheduleAtFixedRate(() -> {
            new SchedularDemo().job();
        }, 5, 2000l, TimeUnit.MILLISECONDS);*/

        //int i = 09;
        System.out.println("I want to run each 2 second");

        Emp e1 = new Emp("Ramesh");
        Emp e2 = new Emp("Suresh");
        Emp e3 = new Emp("Dinesh");

        Set<Emp> empSet = new HashSet<>();

        Map<Emp, Integer> empMap = new HashMap<>();

        empSet.add(e1);
        empSet.add(e1);
        empSet.add(e1);
        System.out.println("Size of set is "+empSet.size());

        empMap.put(e1, 1);
        empMap.put(e2, 2);
        empMap.put(e3, 3);


        System.out.println("Size of set is "+empMap.size()+" Map is "+empMap);
    }

    private void job(){
        System.out.println("I want to run each 2 second");
    }

}

class Emp{
    private String name;

    public Emp(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        /*if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return name.equals(emp.name);*/
        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                '}';
    }
}


