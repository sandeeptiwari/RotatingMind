package com.rotatingmind;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ExerciseTest {

    private static final List<ArrayList<String>> arrayListOfNames = Lists.newArrayList(
            Lists.newArrayList("Mariam", "Alex", "Ismail"),
            Lists.newArrayList("John", "Alesha", "Andre"),
            Lists.newArrayList("Susy", "Ali")
    );

    @BeforeEach
    public void setUp() {
        System.out.println(arrayListOfNames);
    }

    @Test
    public void withoutFlatMap() throws Exception {
//  [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
        List<String> results = arrayListOfNames.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(results);
    }
}
