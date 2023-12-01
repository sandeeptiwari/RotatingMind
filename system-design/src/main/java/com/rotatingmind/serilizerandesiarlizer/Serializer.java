package com.rotatingmind.serilizerandesiarlizer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Serializer {


    public String serialize(Object object) throws IllegalAccessException {
        String serializeData = "";
        Class c = object.getClass();

        serializeData += "{";

        List<Field> allFields = getAllFields(c);
        for (Field f : allFields) {
            f.setAccessible(true);
            String name  = f.getName();
            serializeData += name;
            serializeData += ":";

            Object val = f.get(object);

            if (val.getClass().equals(Integer.class) || val.getClass().equals(Double.class)) {
                serializeData += val;
            } else {
                serializeData += serialize(val);
            }
            serializeData += ",";
        }

        serializeData = serializeData.substring(0, serializeData.length() - 1);

        serializeData += "}";

        return serializeData;
    }

    private List<Field> getAllFields(Class c) {
        List<Field> fields = new ArrayList<>();

        while (c != null) {
            for (Field f : c.getDeclaredFields()) {
                fields.add(f);
            }
            c = c.getSuperclass();
        }
        return fields;
    }
}
