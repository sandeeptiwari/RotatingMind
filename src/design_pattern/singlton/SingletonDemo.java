package design_pattern.singlton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SingletonDemo {

    private static void saveToFile(Authentication authentication, String fileName) throws IOException {

        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
            objOut.writeObject(authentication);
        }
    }

    private static Authentication readFromFile(String fileName) throws IOException, ClassNotFoundException {

        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
            return (Authentication) objIn.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var authentication = Authentication.getInstance();
        authentication.setValue(111);

        String fileName = "authentication.bin";
        saveToFile(authentication, fileName);

        authentication.setValue(222);

        var authentication1 = readFromFile(fileName);
        System.out.println(authentication == authentication1);

        System.out.println(authentication.getValue());
        System.out.println(authentication1.getValue());
    }
}
