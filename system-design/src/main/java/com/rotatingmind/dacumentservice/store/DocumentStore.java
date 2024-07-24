package com.rotatingmind.dacumentservice.store;


import com.rotatingmind.dacumentservice.model.Document;

public interface DocumentStore {

    void saveDocument(Document document);

    Document getDocument(String id);

    void deleteDocument(String id);

}
