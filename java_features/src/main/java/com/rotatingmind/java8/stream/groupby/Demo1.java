package com.rotatingmind.java8.stream.groupby;

import com.google.common.collect.Lists;
import com.models.Car;
import com.util.MockData;

import javax.swing.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo1 {

    public static void main(String[] args) throws IOException {
        //example2();
        example5();
    }

    public static void example1() throws IOException {
        Map<String, List<String>> carByMake = MockData.getCars()
                .stream()
                .collect(Collectors.groupingBy(Car::getMake,
                        Collectors.mapping(Car::getModel, Collectors.toList())));
        System.out.println("Result " + carByMake);
    }

    public static void example2() throws IOException {
        ArrayList<String> names = Lists.newArrayList("Jhon",
                "Jhon",
                "Mariam",
                "Alex",
                "Mohammado",
                "Mohammado",
                "Vincent",
                "Alex",
                "Alex");
        Map<String, Long> nameByCounting = names.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Result " + nameByCounting);
    }

    public void Example3() throws IOException {
        Map<String, List<Car>> carByMake = MockData.getCars()
                .stream()
                .collect(Collectors.groupingBy(Car::getMake));
        System.out.println("Result " + carByMake);
    }

    //Output: { 19.99=[banana], 29.99=[orange, watermelon], 9.99=[papaya, apple] }
    public static void example4() throws IOException {
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orange", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99")) );

        Map<BigDecimal, Set<String>> itemByPrice = items.stream()
                .collect(Collectors.groupingBy(
                        Item::getPrice,
                        Collectors.mapping(Item::getName, Collectors.toSet())
                ));
        System.out.println(itemByPrice);
    }

    /* In the following String count the number
     * of occurrences of each of the words. There are some variations of this.
     * String sentence = "The big brown fox, jumped over the fence and jumped in a hole.";
     */
    public static void example5() throws IOException {
        String sentence = "The big brown fox, jumped over the fence and jumped in a hole.";
       // Part (A)Word Splitting
        String[] words = sentence
                .trim()
                .replaceAll("[^A-Za-z]", " ")
                .toLowerCase()
                .split("\\s+");
        Arrays.stream(words).forEach(System.out::println);

        // Part (B) Mapping/ Counting
        Map<String, Integer> countMap = new HashMap<>();
        int count = 0;
        for(String word : words){
            count = countMap.containsKey(word) ? countMap.get(word): 0;
            countMap.put(word, count + 1);
        }
    }

    public static void example6() {
        char[] sentence = "The big brown fox, jumped over the fence and jumped in a hole.".toCharArray();
        List<Character> letters = new ArrayList<>();
        for (char letter : sentence)
        {
            letters.add(letter);
        }

        Map<Character, Long> collect = letters.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        collect.forEach((letter, occurrences) -> System.out.println(letter + " - " + occurrences));
    }
}

class Item {
    private String name;
    private int qty;
    private BigDecimal price;

    public Item(String name, int qty, BigDecimal price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
