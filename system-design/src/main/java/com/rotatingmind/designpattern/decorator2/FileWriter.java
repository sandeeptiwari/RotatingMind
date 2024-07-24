package com.rotatingmind.designpattern.decorator2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriter implements Writer {

    private final String filePath;

    public FileWriter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void write(String text) {

        try {
            Files.write(Paths.get(filePath), text.getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
