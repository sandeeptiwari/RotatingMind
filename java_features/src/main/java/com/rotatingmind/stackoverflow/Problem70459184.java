package com.rotatingmind.stackoverflow;

import java.util.Arrays;
import java.util.List;

public class Problem70459184 {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Fridge", 12000l),
                new Product("TV", 21000l),
                new Product("Mixture", 2500l)
        );
        /*Long amount = products.stream()
                .mapToLong(m -> m.getAmount() == null ? 0L : m.getAmount()).sum();*/
        Long amount = products.stream()
                .filter(m -> m.getAmount() != null)
                .mapToLong(Product::getAmount)
                .reduce(0, Long::sum);
        System.out.println(amount);
    }

    static class Product {
        private String name;
        private Long amount;

        public Product(String name, Long amount) {
            this.name = name;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getAmount() {
            return amount;
        }

        public void setAmount(Long amount) {
            this.amount = amount;
        }
    }

}


