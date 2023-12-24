package reflection.demoClass;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ModifierInfo {


    public static void main(String[] args) {
        Entity e = new Entity(1, "Id");
        Class<? extends Entity> aClass = e.getClass();
        int modifiers = aClass.getModifiers();
        int i = modifiers & Modifier.PUBLIC;

        System.out.println(i);


    }
}
