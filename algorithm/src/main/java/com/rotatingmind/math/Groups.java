package com.rotatingmind.math;

import java.util.ArrayList;
import java.util.List;

public class Groups {
    private int firstTerm;
    private int numberOfTerms;
    private List<Integer> sums;

    public Groups() {
        sums = new ArrayList<>();
    }

    public List<Integer> getSums() {
        return sums;
    }

    public void setSums(List<Integer> sums) {
        this.sums = sums;
    }

    public int getFirstTerm() {
        return firstTerm;
    }

    public void setFirstTerm(int firstTerm) {
        this.firstTerm = firstTerm;
    }

    public int getNumberOfTerms() {
        return numberOfTerms;
    }

    public void setNumberOfTerms(int numberOfTerms) {
        this.numberOfTerms = numberOfTerms;
    }

    @Override
    public String toString() {
        return "Groups{" +
                "firstTerm=" + firstTerm +
                ", lastTerm=" + numberOfTerms +
                '}';
    }
}
