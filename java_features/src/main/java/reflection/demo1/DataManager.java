package reflection.demo1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DataManager {

    public static void manage(Object dataProcessor) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class c = dataProcessor.getClass();

        Method m = c.getDeclaredMethod("process", int.class, String.class);
        m.setAccessible(true);
        m.invoke(dataProcessor, 10, "abc");
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        manage(new ApacheProcessor());
    }
}
