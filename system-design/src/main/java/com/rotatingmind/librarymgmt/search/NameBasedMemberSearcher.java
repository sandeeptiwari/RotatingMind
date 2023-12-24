package com.rotatingmind.librarymgmt.search;

import com.rotatingmind.librarymgmt.modle.Member;

import java.util.List;

public class NameBasedMemberSearcher implements MemberSearcher {
    private final String memName;

    public NameBasedMemberSearcher(String memName) {
        this.memName = memName;
    }

    @Override
    public List<Member> search() {
        return null;
    }
}
