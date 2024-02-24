package com.rotatingmind.designpattern.commands;

import java.util.regex.Pattern;

public class PartialMatchDeleteCommand implements Command {

    private final Pattern regex;
    private final PartialMatchDeleter deleter;

    public PartialMatchDeleteCommand(Pattern regex, PartialMatchDeleter deleter) {
        this.regex = regex;
        this.deleter = deleter;
    }


    @Override
    public void execute() {
        deleter.delete(regex);
    }

    @Override
    public void undo() {

    }
}
