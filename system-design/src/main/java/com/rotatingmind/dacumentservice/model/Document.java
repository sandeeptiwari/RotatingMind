package com.rotatingmind.dacumentservice.model;

import java.util.UUID;

public class Document {

    private final String id;
    private final String name;
    private final User owner;
    private final StorageTier storageTier;
    private final AccessControl accessControl;
    private String content;

    public Document(String name, User owner, StorageTier storageTier, String content) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.owner = owner;
        this.storageTier = storageTier;
        this.content = content;
        this.accessControl = new AccessControl();
        initOwnerAccess();
    }

    public boolean isOwner(User user) {
        return owner.equals(user);
    }

    public void changeGlobalAccess(Permission permission) {
        accessControl.changeGlobalAccess(permission);
    }

    public void grantAccess(User user, Permission permission) {
        accessControl.grantPermission(user.username(), permission);
    }

    public boolean hasPermission(User user, Permission permission) {
        Permission userPermission = accessControl.getPermission(user.username());
        if (hasRequiredPermission(userPermission, permission)) {
            return true;
        }

        Permission globalPermission = accessControl.getGlobalPermission();
        return hasRequiredPermission(globalPermission, permission);
    }

    private boolean hasRequiredPermission(Permission actualPermission, Permission requiredPermission) {

        if (actualPermission == null) {
            return false;
        }

        return actualPermission.includes(requiredPermission);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getOwner() {
        return owner;
    }

    public StorageTier getStorageTier() {
        return storageTier;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private void initOwnerAccess() {
        accessControl.grantPermission(owner.username(), Permission.WRITE);
    }
}
