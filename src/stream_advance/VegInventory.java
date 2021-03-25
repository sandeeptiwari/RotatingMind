package stream_advance;

import java.util.List;

public class VegInventory {
    private String category;
    private List<Vegetable> vegetables;

    public VegInventory(String category, List<Vegetable> vegetables) {
        this.category = category;
        this.vegetables = vegetables;
    }

    public String getCategory() {
        return category;
    }

    public List<Vegetable> getVegetables() {
        return vegetables;
    }
}
