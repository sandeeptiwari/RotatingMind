package com.rotatingmind.dacumentservice.util;

public class AppUtil {

    public static String getUniqueDocumentId(String username, String documentName) {
        return username.concat(documentName.toLowerCase());
    }

}
