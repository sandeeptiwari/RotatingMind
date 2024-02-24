package com.rotatingmind.designpattern.commands.api;

import com.rotatingmind.designpattern.commands.Command;
import com.rotatingmind.designpattern.commands.CommandFactory;
import com.rotatingmind.designpattern.commands.PartialMatchDeleter;
import com.rotatingmind.designpattern.commands.PerfectMatchDeleter;
import com.rotatingmind.designpattern.commands.data.MatchType;
import com.rotatingmind.designpattern.commands.helper.TagInserter;

import java.util.regex.Pattern;

public class DeleteTagApi {

    public void deleteTag(String name, MatchType matchType) {
        Command command = null;

        if (matchType.equals(MatchType.PERFECT)) {
            command = CommandFactory.getPerfectMatchDeleteCmd(name, new PerfectMatchDeleter(), new TagInserter());
        } else if (matchType.equals(MatchType.PARTIAL)) {
            command = CommandFactory.getPartialMatchDeleteCmd(Pattern.compile(name), new PartialMatchDeleter(), new TagInserter());
        } else {
            throw new IllegalArgumentException("Invalid match type");
        }

        command.execute();

    }
}
