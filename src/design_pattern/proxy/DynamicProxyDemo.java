package design_pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

interface Human {
    void walk();
    void talk();
}

class Person implements Human {

    @Override
    public void walk() {
        System.out.println("I am walking");
    }

    @Override
    public void talk() {
        System.out.println("I am talking");
    }
}

class LoggingHandler implements InvocationHandler {
    private Object target;
    private Map<String, Integer> calls = new HashMap<>();

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        var name = method.getName();

        if (name.contains("toString")) {
            return calls.toString();
        }

        // add or increment number of calls
        calls.merge(name, 1, Integer::sum);
        return method.invoke(target, args);
    }
}

public class DynamicProxyDemo {

    @SuppressWarnings("unchecked")
    public static <T> T  withLogging(T target, Class<T> itf) {
        return (T)Proxy.newProxyInstance(
                itf.getClassLoader(),
                new Class<?>[]{itf},
                new LoggingHandler(target)
        );
    }

    public static void main(String[] args) {
        Person person = new Person();
        var human = withLogging(person, Human.class);
        human.talk();
        human.walk();
        human.walk();
        System.out.println(human);
    }
}
