package com.rotatingmind.hackthon.repo;


import com.rotatingmind.hackthon.domain.DB;
import com.rotatingmind.hackthon.domain.HackthonUser;

import java.util.List;

public class UserRepository implements Repository<HackthonUser, Long> {

    @Override
    public HackthonUser save(HackthonUser hackthonUser) {
        return DB.getInstance().addUser(hackthonUser);
    }

    @Override
    public HackthonUser findById(Long id) {
        return null;
    }

    @Override
    public List<HackthonUser> findAll() {
        return List.of();
    }
}
