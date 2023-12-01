package com.rotatingmind.serilizerandesiarlizer.domain;

public class ScienceMark {

    private int phyMarks;
    private int chemMarks;

    private int mathsMarks;

    private double sciPercent;


    public int getPhyMarks() {
        return phyMarks;
    }

    public void setPhyMarks(int phyMarks) {
        this.phyMarks = phyMarks;
    }

    public int getChemMarks() {
        return chemMarks;
    }

    public void setChemMarks(int chemMarks) {
        this.chemMarks = chemMarks;
    }

    public int getMathsMarks() {
        return mathsMarks;
    }

    public void setMathsMarks(int mathsMarks) {
        this.mathsMarks = mathsMarks;
    }

    public double getSciPercent() {
        return sciPercent;
    }

    public void setSciPercent(double sciPercent) {
        this.sciPercent = sciPercent;
    }

    @Override
    public String toString() {
        return "ScienceMark{" +
                "phyMarks=" + phyMarks +
                ", chemMarks=" + chemMarks +
                ", mathsMarks=" + mathsMarks +
                ", sciPercent=" + sciPercent +
                '}';
    }
}
