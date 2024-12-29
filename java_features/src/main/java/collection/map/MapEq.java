package collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapEq {

    public static void main(String[] args) {
        Map<WorkDay, String> m = new HashMap<>();
        WorkDay t1 = new WorkDay("Maonday");
        WorkDay t2 = new WorkDay("Maonday");
        WorkDay t3 = new WorkDay("Tuesday");

        m.put(t1, "travel");
        m.put(t2, "play");
        m.put(t3, "work");

        System.out.println(m.size());
    }
}

class WorkDay {
    String day;

    public WorkDay(String day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        /*if (this == o) return true;
        if (!(o instanceof WorkDay workDay)) return false;
        return Objects.equals(day, workDay.day);*/

        return ((WorkDay) o).day == this.day;
    }

   /* @Override
    public int hashCode() {
        return Objects.hashCode(day);
    }*/
}
