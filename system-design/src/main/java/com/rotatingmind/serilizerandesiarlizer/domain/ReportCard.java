package com.rotatingmind.serilizerandesiarlizer.domain;

public class ReportCard {
    private  int id;
    private  ScienceMark scienceMark;

    private  ArtsMarks artMarks;

    private  double totalPercentage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ScienceMark getScienceMark() {
        return scienceMark;
    }

    public void setScienceMark(ScienceMark scienceMark) {
        this.scienceMark = scienceMark;
    }

    public ArtsMarks getArtMarks() {
        return artMarks;
    }

    public void setArtMarks(ArtsMarks artMarks) {
        this.artMarks = artMarks;
    }

    public double getTotalPercentage() {
        return totalPercentage;
    }

    public void setTotalPercentage(double totalPercentage) {
        this.totalPercentage = totalPercentage;
    }

    public ReportCard() {
    }


    @Override
    public String toString() {
        return "ReportCard{" +
                "id=" + id +
                ", scienceMark=" + scienceMark +
                ", artMarks=" + artMarks +
                ", totalPercentage=" + totalPercentage +
                '}';
    }
}
