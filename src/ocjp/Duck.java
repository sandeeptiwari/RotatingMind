package ocjp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public final class Duck {
    private String name;
    private final List<Duck> ducklings;//make final

    public Duck(String name, List<Duck> ducklings) {
        this.name = name;
        this.ducklings = new ArrayList<>(ducklings);
    }

    public String getName() {
        return name;
    }

    public List<Duck> getDucklings() {
        return ducklings;
    }

    public String hasDucklins(Predicate<Duck> p) {
        return p.test(this) ? "Quack Quack" : "";
    }
}

