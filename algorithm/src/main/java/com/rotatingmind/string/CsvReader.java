package com.rotatingmind.string;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * problem: We have Sales data in csv file. Find the city and month in which maximum items sold.
 * City, date, unit sold
 * NY , 01-01-2021, 100
 * NY, 15-01-2021, 200
 * DC, 15-02-2021, 1900
 * VI, 15-03-2021, 1000
 * MN, 15-03-2021, 100
 * ABC, 15-03-2021, 700
 * ABC, 15-05-2021, 350
 * MN, 15-07-2021, 350
 * MN, 15-07-2021, 350
 */
public class CsvReader {

    public static void main(String[] args) {

    }

    private Item processTheFile(File file) throws IOException {
        try(Stream<String> lines = Files.lines(Paths.get("filePath"))) {
              lines.map(line -> {
                          String arr[] = line.split(",");
                          return new Item(arr[0], arr[1], Integer.valueOf(arr[2]));
                      }).collect(Collectors.toMap(Item::getQuantity, Function.identity()))
                      .entrySet().stream().max(Map.Entry.comparingByKey()).get().getValue();

        }
        return null;
    }
}

class Item {
   private String city;
   private String date;
   private Integer quantity;

    public Item(String city, String date, Integer quantity) {
        this.city = city;
        this.date = date;
        this.quantity = quantity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

