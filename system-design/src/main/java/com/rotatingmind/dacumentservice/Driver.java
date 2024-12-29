package com.rotatingmind.dacumentservice;


import com.rotatingmind.dacumentservice.model.Permission;
import com.rotatingmind.dacumentservice.model.StorageTier;
import com.rotatingmind.dacumentservice.model.User;
import com.rotatingmind.dacumentservice.service.DocumentService;
import com.rotatingmind.dacumentservice.service.DocumentServiceImpl;

public class Driver {
    public static void main(String[] args) {

        User naman = new User("naman_nmt");
        User satish = new User("satish");

        DocumentService documentService = DocumentServiceImpl.getInstance();

        String content = """
                This is the first document
                """;

        StringBuilder documentContent = new StringBuilder(content);

        documentService.createDocument("Test Doc", documentContent.toString(), naman, StorageTier.HOT);

        documentService.readDocument("Test Doc", naman);

        documentService.changeGlobalPermission("Test Doc", naman, Permission.READ);

        documentService.readDocument("Test Doc", satish);

        documentService.grantAccessToDocument("Test Doc", naman, satish, Permission.WRITE);

        documentService.readDocument("Test Doc", satish);


        documentContent.append("\nThis is new line after update");
        documentService.editDocument("Test Doc", documentContent.toString(), satish);

        documentService.readDocument("Test Doc", satish);

        documentService.deleteDocument("Test Doc", naman);

        documentService.readDocument("Test Doc", naman);
    }
}
