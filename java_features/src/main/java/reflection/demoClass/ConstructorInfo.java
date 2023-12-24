package reflection.demoClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ConstructorInfo {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("reflection.demoClass.Entity");
        Constructor<?>[] constructors = aClass.getConstructors();
        Constructor<?>[] constructors1 = aClass.getDeclaredConstructors();

        Arrays.stream(constructors)
                .forEach(ele -> System.out.println(ele.getName()));

        Arrays.stream(constructors1)
                .forEach(ele -> System.out.println(ele));

        System.out.println("====================================================================");
        Constructor<?> constructor = aClass.getConstructor(int.class, String.class);
        Entity e = (Entity) constructor.newInstance(10, "StudentId");
        System.out.println(e.getType());
        System.out.println("====================================================================");
        Constructor<?> privateConstructor1 = aClass.getDeclaredConstructor();
        privateConstructor1.setAccessible(true);
        Entity o = (Entity) privateConstructor1.newInstance();
        System.out.println("Default Vale " + o.getVal() + " Type " + o.getType());
    }
}
