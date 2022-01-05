package com.rotatingmind.stackoverflow;

import java.util.*;
import java.util.stream.Collectors;

//Map<Year, List<ObjectB>>  to Map<Year, ObjectC>
public class Problem70451560 {

    public static void main(String[] args) {
        Year y1 = new Year(2001);
        Year y2 = new Year(2003);
        Year y3 = new Year(2006);
        Map<Year, List<ObjectB>> objectBByYear = new HashMap<>();
        objectBByYear.put(y1, Arrays.asList(new ObjectB(
                        new ObjectBA(10),
                        new ObjectBB(20)
                ),
                new ObjectB(
                        new ObjectBA(30),
                        new ObjectBB(40)
                )));
        objectBByYear.put(y2, Arrays.asList(new ObjectB(
                        new ObjectBA(15),
                        new ObjectBB(25)
                ),
                new ObjectB(
                        new ObjectBA(35),
                        new ObjectBB(45)
                )));
        objectBByYear.put(y3, Arrays.asList(new ObjectB(
                        new ObjectBA(11),
                        new ObjectBB(21)
                ),
                new ObjectB(
                        new ObjectBA(31),
                        new ObjectBB(41)
                )));

        Map<Year, ObjectC> resultMap = objectBByYear.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> convert(entry.getValue())));

        System.out.println(resultMap);
    }

    private static ObjectC convert(List<ObjectB> objectBs) {
        /*c.getBa().add(b.getBa());
                    c.getBb().add(b.getBb());*/
        return objectBs.stream().collect(
                () -> new ObjectC(new ArrayList<>(), new ArrayList<>()),
                ObjectC::add,
                (c1, c2) -> {
                    c1.getBa().addAll(c2.getBa());
                    c1.getBb().addAll(c2.getBb());
                }
        );
    }

    private static ObjectC convert1(List<ObjectB> objectBs) {
        ObjectC objectC = new ObjectC(new ArrayList<>(), new ArrayList<>());
        for (ObjectB objectb : objectBs) {
            objectC.add(objectb);
        }
        return objectC;
    }

}

class Year {
    private int year;

    public Year(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Year year1 = (Year) o;
        return year == year1.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year);
    }

    @Override
    public String toString() {
        return "" + year;
    }
}

class ObjectB {
    private ObjectBA ba;
    private ObjectBB bb;

    public ObjectB(ObjectBA ba, ObjectBB bb) {
        this.ba = ba;
        this.bb = bb;
    }

    public ObjectBA getBa() {
        return ba;
    }

    public void setBa(ObjectBA ba) {
        this.ba = ba;
    }

    public ObjectBB getBb() {
        return bb;
    }

    public void setBb(ObjectBB bb) {
        this.bb = bb;
    }

    @Override
    public String toString() {
        return "ObjectB{" +
                "ba=" + ba +
                ", bb=" + bb +
                '}';
    }
}

class ObjectC {
    private List<ObjectBA> ba;
    private List<ObjectBB> bb;

    public ObjectC(List<ObjectBA> ba, List<ObjectBB> bb) {
        this.ba = ba;
        this.bb = bb;
    }

    public void add(ObjectB b) {
        this.ba.add(b.getBa());
        this.bb.add(b.getBb());
    }

    public List<ObjectBA> getBa() {
        return ba;
    }

    public void setBa(List<ObjectBA> ba) {
        this.ba = ba;
    }

    public List<ObjectBB> getBb() {
        return bb;
    }

    public void setBb(List<ObjectBB> bb) {
        this.bb = bb;
    }

    @Override
    public String toString() {
        return "ObjectC{" +
                "ba=" + ba +
                ", bb=" + bb +
                '}';
    }
}

class ObjectBA {
    private int value;

    public ObjectBA(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ObjectBA{" +
                "value=" + value +
                '}';
    }
}

class ObjectBB {
    private int value;

    public ObjectBB(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ObjectBB{" +
                "value=" + value +
                '}';
    }
}

