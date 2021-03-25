import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Receiver{
	
	public static void main(String...args){
		
		try{
            //serializing
            String fileName = "E://practice//test//file.ser";
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Emp emp =(Emp)ois.readObject();
			System.out.println(emp);
			
			fis.close();
			ois.close();
			
        }catch (IOException | ClassNotFoundException e ) {
            e.printStackTrace();
        } 
		
	}
}