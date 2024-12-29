package com.rotatingmind.dacumentservice.service;


import com.rotatingmind.dacumentservice.exception.AccessDeniedException;
import com.rotatingmind.dacumentservice.exception.DocumentNotFoundException;
import com.rotatingmind.dacumentservice.factory.DocumentStoreFactory;
import com.rotatingmind.dacumentservice.model.*;
import com.rotatingmind.dacumentservice.store.DocumentStore;
import com.rotatingmind.dacumentservice.util.AppUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DocumentServiceImpl implements DocumentService {

    private static DocumentServiceImpl instance;

    private final DocumentStoreFactory factory;
    private final Map<String, DocumentMetaData> documentMetaData;
    private final Map<String, DocumentMetaData> globalDocumentMetaData;

    private DocumentServiceImpl() {
        this.factory = new DocumentStoreFactory();
        this.documentMetaData = new HashMap<>();
        this.globalDocumentMetaData = new HashMap<>();
    }

    public static DocumentService getInstance() {
        if (instance == null) {
            instance = new DocumentServiceImpl();
        }
        return instance;
    }

    @Override
    public void createDocument(String name, String content, User user, StorageTier storageTier) {
        Document document = new Document(name, user, storageTier, content);
        DocumentStore documentStore = factory.getDocumentStore(storageTier);
        documentStore.saveDocument(document);
        DocumentMetaData metaData = new DocumentMetaData(storageTier, document.getId());
        documentMetaData.put(AppUtil.getUniqueDocumentId(user.username(), name), metaData);
        System.out.printf("Document created with name %s by user %s%n", name, user.username());
    }

    @Override
    public void readDocument(String name, User user) {
        Document document = getDocument(name, user, Permission.READ);
        printDocumentDetails(document);
    }

    @Override
    public void grantAccessToDocument(String name, User owner, User toUser, Permission permission) {
        Document document = getDocumentForOwner(name, owner);
        document.grantAccess(toUser, permission);
        documentMetaData.put(AppUtil.getUniqueDocumentId(toUser.username(), name),
                new DocumentMetaData(document.getStorageTier(), document.getId()));
        System.out.printf("Access granted to user %s%n", toUser.username());
    }

    @Override
    public void editDocument(String name, String content, User user) {
        Document document = getDocument(name, user, Permission.WRITE);
        document.setContent(content);
        System.out.printf("Document '%s' updated by user '%s'%n", name, user.username());
    }

    @Override
    public void deleteDocument(String name, User user) {
        Document document = getDocumentForOwner(name, user);
        DocumentStore documentStore = factory.getDocumentStore(document.getStorageTier());
        documentStore.deleteDocument(document.getId());
        documentMetaData.remove(AppUtil.getUniqueDocumentId(user.username(), name));
        globalDocumentMetaData.remove(AppUtil.getUniqueDocumentId("GLOBAL", name));
        System.out.printf("Document '%s' deleted by user '%s'%n", name, user.username());
    }

    @Override
    public void changeGlobalPermission(String name, User user, Permission permission) {
        Document document = getDocumentForOwner(name, user);
        document.changeGlobalAccess(permission);
        globalDocumentMetaData.put(AppUtil.getUniqueDocumentId("GLOBAL", name),
                new DocumentMetaData(document.getStorageTier(), document.getId()));
        System.out.println("Global permission updated");
    }

    private Document getDocument(String name, User user, Permission requiredPermission) {
        String uniqueDocumentId = AppUtil.getUniqueDocumentId(user.username(), name);
        DocumentMetaData metaData = Optional.ofNullable(documentMetaData.get(uniqueDocumentId))
                .orElse(globalDocumentMetaData.get(AppUtil.getUniqueDocumentId("GLOBAL", name)));

        if (metaData == null) {
            throw new DocumentNotFoundException(
                    "Document with name " + name + " does not exist for user " + user.username()
            );
        }

        DocumentStore documentStore = factory.getDocumentStore(metaData.storageTier());
        Document document = documentStore.getDocument(metaData.documentId());

        if (!document.hasPermission(user, requiredPermission)) {
            throw new AccessDeniedException(
                    "User %s does not have %s access".formatted(user.username(), requiredPermission)
            );
        }

        return document;
    }

    private Document getDocumentForOwner(String name, User owner) {
        String uniqueDocumentId = AppUtil.getUniqueDocumentId(owner.username(), name);

        if (!documentMetaData.containsKey(uniqueDocumentId)) {
            throw new DocumentNotFoundException(
                    "Document with name " + name + " does not exist for user " + owner.username()
            );
        }

        DocumentMetaData metaData = documentMetaData.get(uniqueDocumentId);
        DocumentStore documentStore = factory.getDocumentStore(metaData.storageTier());
        Document document = documentStore.getDocument(metaData.documentId());

        if (!document.isOwner(owner)) {
            throw new AccessDeniedException(
                    "Only the owner can perform this action"
            );
        }

        return document;
    }

    private void printDocumentDetails(Document document) {
        String documentDetails = """
                ###################
                Document Name: %s
                Storage Tier: %s
                Content: %s
                ###################
                """.formatted(
                document.getName(),
                document.getStorageTier(),
                document.getContent()
        );
        System.out.println(documentDetails);
    }
}
