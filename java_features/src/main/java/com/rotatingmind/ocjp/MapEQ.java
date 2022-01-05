package com.rotatingmind.ocjp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapEQ {

    public static void main(String[] args) {
        Map<WorkDay, String> map = new HashMap<>();
        WorkDay t1 = new WorkDay("Monday");
        WorkDay t2 = new WorkDay("Monday");
        WorkDay t3 = new WorkDay("Tuesday");

        map.put(t1, "travel");
        map.put(t2, "play");
        map.put(t3, "work");

        System.out.println(map.size());
    }
}

class WorkDay {
    private String day;

    public WorkDay(String day) {
        this.day = day;
    }

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkDay workDay = (WorkDay) o;
        return Objects.equals(day, workDay.day);
    }*/

    @Override
    public int hashCode() {
        return 1;
    }
}
