package com.rotatingmind.designpattern.commands;

import java.util.Stack;

public class TagManager {

    private final Stack<Command> oldCommands;

    /*public void insertTag(String tag) {}


    public void deleteTag(String tag) {}

    public void deleteTagByRegex(String tag) {}

    public void updateTag(String old, String tag) {}*/


    public TagManager() {
        this.oldCommands = new Stack<>();
    }

    public void changeTags(Command command) {
        command.execute();
        oldCommands.push(command);
    }

    public void undo() {
        if(oldCommands.empty()) {
            throw new RuntimeException("No command to undo");
        }
        Command command = oldCommands.peek();
        command.undo();
        oldCommands.pop();
    }
}
