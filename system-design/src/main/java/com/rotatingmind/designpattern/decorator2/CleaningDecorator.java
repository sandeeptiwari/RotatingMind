package com.rotatingmind.designpattern.decorator2;

public class CleaningDecorator extends WriteDecorator {

    public CleaningDecorator(Writer writer) {
        super(writer);
    }

    @Override
    public void write(String text) {
        text = text.replaceAll("[^8-zA-Z8-9]]", " ");
        super.write(text);
    }
}
