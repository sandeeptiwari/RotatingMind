package singlton_pattern;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Elvis implements Serializable {
    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("accessed");
    }

    // readResolve method to preserve singleton property
    public Object readResolve() throws ObjectStreamException{
        return INSTANCE;
    }


    public static void main(String...args) throws IllegalAccessException, InvocationTargetException, InstantiationException, IOException, ClassNotFoundException {
        /*Constructor[] c = Elvis.class.getDeclaredConstructors();
        for (Constructor con : c){
            con.setAccessible(true);

            Elvis e = (Elvis)con.newInstance();
            e.leaveTheBuilding();
        }*/

        Elvis e = Elvis.getInstance();


        String fileName = "serialSinlton.ser";

        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(e);

        fos.close();
        oos.close();


        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Elvis e1 = (Elvis) ois.readObject();

        fis.close();
        ois.close();

        System.out.println("e hashcode = "+e.hashCode());
        System.out.println("e1 hashcode = "+e1.hashCode());
    }

    private void readObject(ObjectInputStream aInputStream){
        System.out.println("call");
    }

}

interface Inter{
    void self();
}

enum ElvisEnumSinglton implements Inter{
    INSTANCE;
    public void leaveTheBuilding() { }

    public void self(){}
}
