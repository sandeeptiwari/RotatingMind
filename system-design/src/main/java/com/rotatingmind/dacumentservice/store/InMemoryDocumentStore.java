package com.rotatingmind.dacumentservice.store;



import com.rotatingmind.dacumentservice.model.Document;
import com.rotatingmind.dacumentservice.util.AppUtil;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDocumentStore implements DocumentStore {

    private static InMemoryDocumentStore instance;

    private final Map<String, String> usernameAndDocumentIdMapping;
    private final Map<String, Document> documents;

    private InMemoryDocumentStore() {
        this.usernameAndDocumentIdMapping = new HashMap<>();
        this.documents = new HashMap<>();
    }

    public static synchronized DocumentStore getInstance() {
        if (instance == null) {
            instance = new InMemoryDocumentStore();
        }
        return instance;
    }

    @Override
    public void saveDocument(Document document) {

        String uniqueDocumentId = AppUtil.getUniqueDocumentId(
                document.getOwner().username(),
                document.getName()
        );

        usernameAndDocumentIdMapping.put(uniqueDocumentId, document.getId());
        documents.put(document.getId(), document);
    }

    @Override
    public Document getDocument(String id) {
        return documents.get(id);
    }

    @Override
    public void deleteDocument(String id) {
        documents.remove(id);
    }


}
