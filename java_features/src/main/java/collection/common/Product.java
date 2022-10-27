package collection.common;

import java.util.Comparator;

public record Product(String name, int weight) {

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public static final Comparator<Product> BY_WEIGHT =
            Comparator.comparingInt(Product::weight);
}
