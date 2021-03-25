package package1;

import java.io.*;

public class SerializationDemo {

    public static void main(String...args){
         String fileName = "file.ser";
         SrM ser = new SrM();
        try(FileOutputStream fos = new FileOutputStream(fileName); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(ser);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ser.setJ(333);
        try(FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis);) {
            SrM sr= (SrM)ois.readObject();
            System.out.println("i = "+sr.getI()+ " J = "+sr.getJ());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

final class SrM implements Serializable{
    private static final long seri = 45l;
    private int i = 10;
    private int j = 20;

    public void setJ(int j) {
        this.j = j;
    }

    public int getI() {
        return i;
    }



    public int getJ() {
        return j;
    }

}