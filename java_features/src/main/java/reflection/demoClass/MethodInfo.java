package reflection.demoClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodInfo {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Entity e = new Entity(10, "id");

        Class<? extends Entity> aClass = e.getClass();
        Method[] methods = aClass.getMethods();

        Arrays.stream(methods)
                .forEach(m -> System.out.println(m.getName()));
        System.out.println("================================================================");

        Method[] declaredMethods = aClass.getDeclaredMethods();

        Arrays.stream(declaredMethods)
                .forEach(m -> System.out.println("Declared " + m.getName()));
        System.out.println("================================================================");

        Method setVal = aClass.getMethod("setVal", int.class);
        Method getVal = aClass.getMethod("getVal");
        getVal.setAccessible(true);
        Object invoke = setVal.invoke(e, 15);
        int val = (int)getVal.invoke(e);
        System.out.println("setVale :: = " + val);
    }
}
