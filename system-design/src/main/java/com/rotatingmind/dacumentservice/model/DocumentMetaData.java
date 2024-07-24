package com.rotatingmind.dacumentservice.model;

public record DocumentMetaData(
        StorageTier storageTier,
        String documentId
) {
}
