package reflection;

import reflection.scanpkg.Man;

public class TestReflection {


    public static void main(String[] args) {
        Man man = new Man();
        Class<? extends Man> aClass = man.getClass();
        System.out.println(aClass.getPackageName());
    }
}
