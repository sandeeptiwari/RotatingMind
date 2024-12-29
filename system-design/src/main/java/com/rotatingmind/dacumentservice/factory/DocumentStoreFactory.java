package com.rotatingmind.dacumentservice.factory;


import com.rotatingmind.dacumentservice.model.StorageTier;
import com.rotatingmind.dacumentservice.store.DocumentStore;
import com.rotatingmind.dacumentservice.store.InMemoryDocumentStore;

public class DocumentStoreFactory {

    public DocumentStore getDocumentStore(StorageTier storageTier) {
        switch (storageTier) {
            case HOT -> {
                return InMemoryDocumentStore.getInstance();
            }
            default -> throw new IllegalArgumentException("Invalid storage tier");
        }
    }

}
