package com.rotatingmind.serilizerandesiarlizer.domain;

public class ArtsMarks {

    private int socialScienceMarks;

    private int literatureMarks;

    private  int homeScienceMarks;

    private int englishMarks;

    private double artPercentage;

    public int getSocialScienceMarks() {
        return socialScienceMarks;
    }

    public void setSocialScienceMarks(int socialScienceMarks) {
        this.socialScienceMarks = socialScienceMarks;
    }

    public int getLiteratureMarks() {
        return literatureMarks;
    }

    public void setLiteratureMarks(int literatureMarks) {
        this.literatureMarks = literatureMarks;
    }

    public int getHomeScienceMarks() {
        return homeScienceMarks;
    }

    public void setHomeScienceMarks(int homeScienceMarks) {
        this.homeScienceMarks = homeScienceMarks;
    }

    public int getEnglishMarks() {
        return englishMarks;
    }

    public void setEnglishMarks(int englishMarks) {
        this.englishMarks = englishMarks;
    }

    public double getArtPercentage() {
        return artPercentage;
    }

    public void setArtPercentage(double artPercentage) {
        this.artPercentage = artPercentage;
    }

    @Override
    public String toString() {
        return "ArtsMarks{" +
                "socialScienceMarks=" + socialScienceMarks +
                ", literatureMarks=" + literatureMarks +
                ", homeScienceMarks=" + homeScienceMarks +
                ", englishMarks=" + englishMarks +
                '}';
    }
}
