import java.io.File;
import java.io.IOException;

public class FileOps {


    public static void main(String[] argv) throws IOException {

        File folder = new File("D:\\practice\\play_with_code\\RotatingMind\\pardeep\\");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {

            if (listOfFiles[i].isFile()) {

                File f = new File("D:\\practice\\play_with_code\\RotatingMind\\pardeep\\"+listOfFiles[i].getName()); 

                f.renameTo(new File("D:\\practice\\play_with_code\\RotatingMind\\pardeep\\"+i+".txt"));
            }
        }

        System.out.println("conversion is done");
    }
}