package testingframework;

import java.lang.reflect.Method;
import java.util.Arrays;

public class SimpleUnitTester {

    public int execute(Class clazz) throws Exception {
        long failedCount = Arrays.stream(clazz.getDeclaredMethods())
                .map(Method::getName)
                .filter(name -> name.startsWith("test"))
                .count();

        return (int) failedCount;
    }
}
