package com.rotatingmind.designpattern.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {

    public static void main(String[] args) {
        int c;

        try {
            //Path ospdPath = Paths.get(InputTest.class.getClassLoader().getResource("./test.txt").toURI());
            InputStream in = new LowerCaseInputStream(
                    new BufferedInputStream(
                            new FileInputStream("D:\\practice\\rotatingmindworks\\system-design\\test.txt")
                    )
            );

            while ((c = in.read()) >= 0) {
                System.out.print((char)c);
            }
            in.close();

        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }
}
