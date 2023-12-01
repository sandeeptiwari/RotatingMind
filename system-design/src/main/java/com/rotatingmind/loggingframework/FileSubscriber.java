package com.rotatingmind.loggingframework;

import java.io.FileWriter;
import java.io.IOException;

public class FileSubscriber implements Subscriber {

    private final FileWriter fileWriter;

    public FileSubscriber(String filePath) throws IOException {
        this.fileWriter = new FileWriter(filePath);
    }

    @Override
    public void update(String message) {
        try {
            fileWriter.write(message + "\n");
            fileWriter.flush();
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
