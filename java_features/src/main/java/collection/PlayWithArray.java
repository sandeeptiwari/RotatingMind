package collection;

import collection.common.Product;

import java.util.Arrays;

public class PlayWithArray {

    public static void main(String[] args)
    {
        var door = new Product("Wooden Door", 35);
        var floorPanel = new Product("Floor Panel", 25);
        var window = new Product("Glass Window", 10);

        // Create
        Product[] products = {door, floorPanel};
        System.out.println(products);
        // Print
        System.out.println(Arrays.toString(products));
        // Add
        products = add(window, products);

        // Duplicate
        products = add(window, products);
        System.out.println(Arrays.toString(products));
    }

    private static Product[] add(Product product, Product[] array)
    {
        int length = array.length;
        var newArray = Arrays.copyOf(array, length + 1);
        newArray[length] = product;
        return newArray;
    }
}
