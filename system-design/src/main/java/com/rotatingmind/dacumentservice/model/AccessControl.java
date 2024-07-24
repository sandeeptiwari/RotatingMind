package com.rotatingmind.dacumentservice.model;

import java.util.HashMap;
import java.util.Map;

public class AccessControl {

    private final Map<String, Permission> permissions;
    private Permission globalPermission;

    public AccessControl() {
        this.permissions = new HashMap<>();
    }

    public Permission getGlobalPermission() {
        return globalPermission;
    }

    public Permission getPermission(String username) {
        return permissions.get(username);
    }

    public void grantPermission(String username, Permission permission) {
        permissions.put(username, permission);
    }

    public void changeGlobalAccess(Permission permission) {
        globalPermission = permission;
    }

}
