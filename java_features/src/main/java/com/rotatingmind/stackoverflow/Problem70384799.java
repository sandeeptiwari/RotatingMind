package com.rotatingmind.stackoverflow;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Problem70384799 {

    public static void main(String[] args) {

    }

    public List<Obj3> convertToObj3(List<Obj1> obj1s, List<Obj2> obj2s){
        Map<String, Obj1> obj3ByCode =
                obj1s.stream()
                        .collect(Collectors.toMap(Obj1::getCode, Function.identity()));

        return obj2s.stream()
                .filter(isMatch(obj3ByCode))
                .map(obj2 -> new Obj3(obj3ByCode.get(obj2.getName()).getCode(), obj2.getDataType()))
                .collect(Collectors.toList());
    }

    private Predicate<Obj2> isMatch(Map<String, Obj1> obj3ByCode) {
        Predicate<Obj2> isCodeSame = obj -> obj3ByCode.getOrDefault(obj.getName(), null) != null;
        Predicate<Obj2> isTypeSame = obj -> obj3ByCode.getOrDefault(obj.getName(), null).getDataType()
                .equalsIgnoreCase(obj.getDataType());
        return isCodeSame.and(isTypeSame);
    }
}

class Obj3 {
    private String category;
    private String type;

    public Obj3(String category, String type) {
        this.category = category;
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Obj2 {
    private String name;
    private String dataType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}

class Obj1 {
    private String code;
    private String dataType;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
