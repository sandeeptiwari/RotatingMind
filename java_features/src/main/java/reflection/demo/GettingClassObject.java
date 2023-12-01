package reflection.demo;


class Hello {
    
}
public class GettingClassObject {

    public static void main(String[] args) throws Exception {
        //1. forname

        Class<?> c1 = Class.forName("java.lang.String");
        Class<?> c2 = Class.forName("java.lang.String");

        /**
         * SO all class object created from same class, shared same object
         */
        System.out.println(c1 == c2);
        
        
        // 2. ClassName.class

        Class<Integer> integerClass = int.class;
        
        //3. object.class
        Hello h = new Hello();
        Class<? extends Hello> hello = h.getClass();

        Class<?> superclass = hello.getSuperclass();

        Class<?>[] interfaces = hello.getInterfaces();

    }
}
