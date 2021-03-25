package stream_advance;

public class Vegetable {//implements  Comparable<Vegetable>
    private Integer id;
    private String name;
    private String category;

    public Vegetable(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Vegetable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    /*@Override
    public int compareTo(Vegetable o) {
        return this.id.compareTo(o.getId());
    }*/
}
