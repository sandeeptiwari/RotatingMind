package com.rotatingmind.designpattern.commands;

import com.rotatingmind.designpattern.commands.api.DeleteTagApi;
import com.rotatingmind.designpattern.commands.data.MatchType;

public class TagChangeSimulator {

    public static void main(String[] args) {
        new DeleteTagApi().deleteTag("math.*", MatchType.PARTIAL);
    }
}
