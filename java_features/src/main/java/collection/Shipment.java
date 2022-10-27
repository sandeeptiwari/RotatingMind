package collection;

import collection.common.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class Shipment implements Iterable<Product> {
    private static final int LIGHT_VAN_MAX_WEIGHT = 20;
    private static final int MISSING_PRODUCT = -1;

    private final List<Product> products = new ArrayList<>();

    private List<Product> lightVanProducts;
    private List<Product> heavyVanProducts;

    public void add(Product product)
    {
        products.add(product);
    }

    public boolean replace(Product oldProduct, Product newProduct)
    {
        int position = products.indexOf(oldProduct);
        if (position == MISSING_PRODUCT)
        {
            return false;
        }
        else
        {
            products.set(position, newProduct);
            return true;
        }
    }

    public void prepare()
    {
        // Sort the product list
        products.sort(Product.BY_WEIGHT);

        // find the split point
        int splitPoint = findSplitPoint();

        // create two subviews of the list
        lightVanProducts = products.subList(0, splitPoint);
        heavyVanProducts = products.subList(splitPoint, products.size());
    }

    private int findSplitPoint()
    {
        int size = products.size();
        return IntStream.range(0, size)
                .filter(index -> products.get(index).weight() > LIGHT_VAN_MAX_WEIGHT)
                .findFirst()
                .orElse(0);
    }

    public List<Product> getHeavyVanProducts()
    {
        return heavyVanProducts;
    }

    public List<Product> getLightVanProducts()
    {
        return lightVanProducts;
    }

    public Iterator<Product> iterator()
    {
        return products.iterator();
    }

    public boolean stripHeavyProducts()
    {
        return products.removeIf(product -> product.weight() > LIGHT_VAN_MAX_WEIGHT);
    }
}
