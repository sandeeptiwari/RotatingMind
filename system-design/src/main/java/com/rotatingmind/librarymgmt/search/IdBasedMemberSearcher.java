package com.rotatingmind.librarymgmt.search;

import com.rotatingmind.librarymgmt.modle.Member;

import java.util.List;

public class IdBasedMemberSearcher  implements MemberSearcher {
    private final int memId;

    public IdBasedMemberSearcher(int memId) {
        this.memId = memId;
    }

    @Override
    public List<Member> search() {
        return null;
    }
}
