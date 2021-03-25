package stream_advance.util;

import stream_advance.Vegetable;

import java.util.Objects;

public class WrapperVegetable {
    private Vegetable veg;

    public WrapperVegetable(Vegetable veg) {
        this.veg = veg;
    }

    public Vegetable unwrap() {
        return this.veg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapperVegetable that = (WrapperVegetable) o;
        return Objects.equals(veg.getId(), that.veg.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(veg.getId());
    }
}
