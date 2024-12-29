package com.rotatingmind.hackthon.service;

import com.rotatingmind.hackthon.domain.HackthonUser;
import com.rotatingmind.hackthon.repo.Repository;
import com.rotatingmind.hackthon.repo.UserRepository;

public class UserServiceImpl implements UserService {

    private final Repository<HackthonUser, Long> userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepository();
    }

    @Override
    public HackthonUser addUser(HackthonUser user) {
        return userRepository.save(user);
    }
}
