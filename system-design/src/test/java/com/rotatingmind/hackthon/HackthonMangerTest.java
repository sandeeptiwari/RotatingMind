package com.rotatingmind.hackthon;

import com.rotatingmind.hackthon.domain.HackthonUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HackthonMangerTest {

    private HackthonManager hackthonManager = new HackthonManager();

    @DisplayName("Adding a new user successfully")
    @Test
    public void testAddUser() {

        HackthonUser user = new HackthonUser.Builder()
                .setName("A")
                .setDepartment(List.of(1l))
                .build();
        HackthonUser registeredUser = hackthonManager.addUser(user);
        assertNotNull(registeredUser, "Registered user should not be null");
        assertNotEquals(0L, registeredUser.getUserId(), "userId should not be 0");
        assertNotNull(registeredUser.getUserId(), "Registered user should have a userId");
    }
}
