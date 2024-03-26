package com.rotatingmind.food_delivery.domain;

public record FoodItem(Long id,
                       String name,
                       double price,
                       MealType mealType,

                       CuisineType cuisineType,

                       StarRating rating,

                       Long restaurantId,

                       boolean isAvailable) {


    public static Builder builder() {
        return new Builder();
    }

    public static  class Builder {
        private Long id;
        private String name;
        double price;
        private MealType mealType;

        private CuisineType cuisineType;

        private StarRating rating;

        private Long restaurantId;

        private boolean isAvailable;

        public Builder() {}

        public Builder Id(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setMealType(MealType mealType) {
            this.mealType = mealType;
            return this;
        }

        public Builder setCuisineType(CuisineType cuisineType) {
            this.cuisineType = cuisineType;
            return this;
        }

        public Builder setRating(StarRating rating) {
            this.rating = rating;
            return this;
        }

        public Builder setRestaurantId(Long restaurantId) {
            this.restaurantId = restaurantId;
            return this;
        }

        public Builder setAvailable(boolean available) {
            isAvailable = available;
            return this;
        }

        public FoodItem build() {
            return new FoodItem(id, name, price, mealType, cuisineType, rating, restaurantId, isAvailable);
        }
    }

}

