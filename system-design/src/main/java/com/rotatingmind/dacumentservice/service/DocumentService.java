package com.rotatingmind.dacumentservice.service;


import com.rotatingmind.dacumentservice.model.Permission;
import com.rotatingmind.dacumentservice.model.StorageTier;
import com.rotatingmind.dacumentservice.model.User;

public interface DocumentService {

    void createDocument(String name, String content, User user, StorageTier storageTier);

    void readDocument(String name, User user);

    void grantAccessToDocument(String name, User owner, User toUser, Permission permission);

    void editDocument(String name, String content, User user);

    void deleteDocument(String name, User user);

    void changeGlobalPermission(String name, User user, Permission permission);

}
