package com.rotatingmind.designpattern.commands.helper;

import com.rotatingmind.designpattern.commands.Store;

public class TagInserter {

    public void insert(String tag) {
        Store.insert(tag);
    }
}
