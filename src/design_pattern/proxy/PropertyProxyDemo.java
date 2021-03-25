package design_pattern.proxy;

import java.util.Objects;

public class PropertyProxyDemo {

    public static void main(String[] args) {
        Creature creature = new Creature();
        creature.setAgility(12);
        System.out.println(creature);
    }
}

class Property<T> {
    private T value;

    public Property(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Property<?> property = (Property<?>) o;

        return Objects.equals(value, property.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}

class Creature {
    private Property<Integer> agility = new Property<>(10);

    public Integer getAgility() {
        return agility.getValue();
    }

    public void setAgility(Integer agility) {
        // we cannot do agility = value, sadly
        System.out.println("Agility value has been changed");
        this.agility.setValue(agility);
    }

    @Override
    public String toString() {
        return "Creature{" +
                "agility=" + agility.getValue() +
                '}';
    }
}