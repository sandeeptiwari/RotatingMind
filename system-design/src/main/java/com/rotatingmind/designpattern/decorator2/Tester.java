package com.rotatingmind.designpattern.decorator2;

public class Tester {

    public static void main(String[] args) {
        Writer writer = new CleaningDecorator(new UpperCaseDecorator(new ConsoleWriter()));
        writer.write("My#name&is Sandeep");
    }
}
