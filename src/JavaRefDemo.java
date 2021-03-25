import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class JavaRefDemo {

    public static void main(String...args){
        //strongReference();
        //weakReference();
        softreference();
        //phantomReference();
    }

    private static void softreference() {
        Employee employee = new Employee(1001, "SKT");//strong refrence
        SoftReference<Employee> softReference = new SoftReference<>(employee);//weak reference
        System.out.println(softReference.get());
        employee = null;
        System.gc();
        System.out.println(softReference.get());
    }

    private static void weakReference() {
        Employee employee = new Employee(1001, "SKT");//strong refrence
        WeakReference<Employee> weakReference = new WeakReference<>(employee);//weak reference
        System.out.println(weakReference.get());
        employee = null;
        System.gc();
        System.out.println(weakReference.get());
    }

    private static void strongReference() {
        Employee employee = new Employee(1001, "SKT");//strong refrence
        employee = null;// eligible for GC
    }
}

class Employee{

    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

