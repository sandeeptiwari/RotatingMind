package com.rotatingmind.stackoverflow;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


class CustomObject {

    private int id;

    public CustomObject(Builder builder) {
        this.id = builder.id;
    }

    public static class Builder {

        private int id;

        public Builder() {
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public CustomObject build() {
            return new CustomObject(this);
        }
    }
}

public class Problem78692240 {





    public static void main(String[] args) {
        List<Integer> idList = List.of(100, 101, 102, 103, 104);

        Map<Integer, Boolean> idMap =  idList.stream().collect(Collectors.toMap(Function.identity(), ele -> true));

        List<CustomObject> fromDB = List.of(
                new CustomObject.Builder().id(102).build(),
                new CustomObject.Builder().id(104).build()
        );

        fromDB.stream().filter(idMap::containsKey).toList();
    }
}