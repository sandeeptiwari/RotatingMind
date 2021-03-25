package design_pattern.proxy;

public class ProxyDemo {

    public static void main(String[] args) {
       /*Car car = new Car(new Driver("Rahul", 20));
       car.drive();*/

        /*Car car1 = new Car(new Driver("Sonu", 13));
        car1.drive();*/

        Car car1 = new ProxyCar(new Driver("Sonu", 13));
        car1.drive();
    }
}

interface Drivable {
    void drive();
}

class Car implements Drivable {
    protected final Driver driver;

    public Car(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void drive() {
        System.out.println("Car is driven");
    }
}

class Driver {
   private String name;
   private int age;

    public Driver(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class ProxyCar extends Car {

    public ProxyCar(Driver driver) {
        super(driver);
    }

    @Override
    public void drive() {
        if (driver.getAge() >= 16) {
            System.out.println("Car is driven by " + driver.getName());
            super.drive();
        } else {
            System.out.println("Driver is too young to drive the car");
        }
    }
}
