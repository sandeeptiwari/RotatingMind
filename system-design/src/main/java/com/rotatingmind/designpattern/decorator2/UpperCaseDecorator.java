package com.rotatingmind.designpattern.decorator2;

public class UpperCaseDecorator extends WriteDecorator {

    public UpperCaseDecorator(Writer writer) {
        super(writer);
    }

    @Override
    public void write(String text) {
        super.write(text.toUpperCase());
    }
}
