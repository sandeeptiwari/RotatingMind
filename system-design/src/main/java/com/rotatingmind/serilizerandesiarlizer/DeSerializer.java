package com.rotatingmind.serilizerandesiarlizer;

import com.rotatingmind.serilizerandesiarlizer.domain.ArtsMarks;
import com.rotatingmind.serilizerandesiarlizer.domain.ScienceMark;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class DeSerializer {

    private static final String OPEN_CURLY_BRACE = "{";
    private static final String CLOSE_CURLY_BRACE = "}";
    private static final String BLANK_STR = "";
    private static final String COLON = ":";
    private static final String COMMA = ",";
    private static final int FIELD_POS = 0;
    private static final int FIELD_VALUE_POS = 1;
    private static final int COLON_LEN = 1;

    public <T> T deSerialize(String deSerializeStr, Class<T> targetClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        T reportCardInstance = targetClass.getDeclaredConstructor().newInstance();

        String[] values = deSerializeStr.split(COMMA);

        for (String fieldValue : values) {

            String[] innerFields = fieldValue.split(COLON);
            String fieldName = innerFields[FIELD_POS];
            String fieldValueStr = innerFields[FIELD_VALUE_POS];

            fieldName = fieldName.contains(OPEN_CURLY_BRACE) ? fieldName.replace(OPEN_CURLY_BRACE, BLANK_STR) : fieldName.replace(CLOSE_CURLY_BRACE, BLANK_STR);
            fieldValueStr = fieldValueStr.contains(OPEN_CURLY_BRACE) ? fieldValueStr.replace(OPEN_CURLY_BRACE, BLANK_STR) : fieldValueStr.replace(CLOSE_CURLY_BRACE, BLANK_STR);

            Field field = null;
            try {
                field = targetClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                continue;
            }

            field.setAccessible(true);
            Class<?> fieldType = field.getType();

            if (fieldType.equals(int.class)) {
                field.set(reportCardInstance, Integer.parseInt(fieldValueStr));
            } else if (fieldType.equals(double.class)) {
                field.set(reportCardInstance, Double.parseDouble(fieldValueStr));
            } else if (fieldType.equals(ScienceMark.class) || fieldType.equals(ArtsMarks.class)) {
                StringBuilder buildVal = extractReferenceObjStringValue(deSerializeStr, fieldName);
                field.set(reportCardInstance, deSerialize(buildVal.toString(), fieldType));
            } else {
                field.set(reportCardInstance, fieldValueStr);
            }
        }
        return reportCardInstance;
    }

    private StringBuilder extractReferenceObjStringValue(String deSerializeStr, String referenceVarName) {
        int index = deSerializeStr.indexOf(referenceVarName) + referenceVarName.length() + COLON_LEN;
        StringBuilder buildVal = new StringBuilder();
        char bracket = '{';
        while (bracket != '}') {
            char curr = deSerializeStr.charAt(index);
            buildVal.append(curr);
            index++;
            bracket = curr;
        }
        return buildVal;
    }

}
