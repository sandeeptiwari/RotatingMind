package com.util;

import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.models.Car;
import com.models.Person;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.common.reflect.TypeToken;

public class MockData {

    public static ImmutableList<Person> getPeople() throws IOException {
        InputStream inputStream = Resources.getResource("people.json").openStream();
        String json = IOUtils.toString(inputStream);
        Type listType = new TypeToken<ArrayList<Person>>() {
        }.getType();
        List<Person> people = new Gson().fromJson(json, listType);
        return ImmutableList.copyOf(people);
    }

    public static ImmutableList<Car> getCars() throws IOException {
        InputStream inputStream = Resources.getResource("cars.json").openStream();
        String json = IOUtils.toString(inputStream);
        Type listType = new TypeToken<ArrayList<Car>>() {
        }.getType();
        List<Car> cars = new Gson().fromJson(json, listType);
        return ImmutableList.copyOf(cars);
    }

}
