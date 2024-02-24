package com.rotatingmind.designpattern.commands;

import com.rotatingmind.designpattern.commands.helper.TagInserter;

public class InsertTagCommand implements Command {

    private final String name;

    private final TagInserter tagInserter;

    private final PerfectMatchDeleter perfectMatchDeleter;

    public InsertTagCommand(String name, TagInserter tagInserter, PerfectMatchDeleter perfectMatchDeleter) {
        this.name = name;
        this.tagInserter = tagInserter;
        this.perfectMatchDeleter = perfectMatchDeleter;
    }

    @Override
    public void execute() {
        tagInserter.insert(name);
    }

    @Override
    public void undo() {
        perfectMatchDeleter.delete(name);
    }
}
