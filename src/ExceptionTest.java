import java.io.*;

public class ExceptionTest {

    public void show(){
        try{
            badMethod();
            System.out.print("A");
        }catch (Exception e){
            System.out.print("B");
        }finally {
            System.out.print("C");
        }
        System.out.print("D");
    }

    public void badMethod(){
        //throw new RuntimeException();
        Float f = new Float("3.0");
        int a = f.intValue();
        float b = f.floatValue();
        double c = f.doubleValue();

        System.out.println(a + b+ c);
    }

    public static void main(String...args){
        ExceptionTest test = new ExceptionTest();
        test.badMethod();


        try{
            //serializing
            String fileName = "file.ser";
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Emp emp =(Emp)ois.readObject();
            System.out.println(emp);

        }catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
