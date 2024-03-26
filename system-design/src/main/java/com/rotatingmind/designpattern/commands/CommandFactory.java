package com.rotatingmind.designpattern.commands;

import com.rotatingmind.designpattern.commands.helper.TagInserter;

import java.util.regex.Pattern;

public class CommandFactory {

    private CommandFactory() {}

    public static Command getPartialMatchDeleteCmd(
            Pattern pattern, PartialMatchDeleter partialMatchDeleter,
            TagInserter tagInserter
    ) {
        return null;
    }

    public static Command getPerfectMatchDeleteCmd(
            String name, PerfectMatchDeleter perfectMatchDeleter, TagInserter tagInserter
    ) {
        return new PerfectMatchDeleteCommand(name, perfectMatchDeleter, tagInserter);
    }

    public static Command getInsertTagCmd(String name, TagInserter tagInserter, PerfectMatchDeleter perfectMatchDeleter)
    {
        return new InsertTagCommand(name, tagInserter, perfectMatchDeleter);
    }
}
