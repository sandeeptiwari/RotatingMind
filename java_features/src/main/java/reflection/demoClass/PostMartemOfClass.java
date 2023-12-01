package reflection.demoClass;


import java.lang.reflect.Field;
import java.util.stream.Stream;

/**
 * java.lang.Class
 * java.lang.reflect.Field
 * java.lang.reflect.Method
 * java.lang.reflect.Constructor
 * java.lang.reflect.Modifier
 */
public class PostMartemOfClass {

    //Fields

    public static void main(String[] args) throws Exception {
        Entity e1 = new Entity(101, "A");

        Class<? extends Entity> aClass = e1.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();

        Stream.of(declaredFields)
                .forEach(field -> {
                    try {
                        field.setAccessible(true);
                        System.out.println("Name" + field.getName()
                        + "Value " + field.get(e1));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });

        Field type = aClass.getField("type");
        type.set(e1, "rollNo.");

        System.out.println(e1.getType());

        //Field val = aClass.getField("val"); -> NoSuchMethod we have  getField gives only public methods, u need to use getDeclaredFields
        Field val = aClass.getDeclaredField("val");
        val.setAccessible(true);
        val.set(e1, 1001);

        System.out.println(e1.getVal());

    }
}
