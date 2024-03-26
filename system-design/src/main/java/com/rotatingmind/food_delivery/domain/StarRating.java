package com.rotatingmind.food_delivery.domain;

public enum StarRating {
    ONE(1),
    TWO(2),
    THREE(3),

    FOUR(4),

    FIVE(5);

    private final int rating;

    StarRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}
