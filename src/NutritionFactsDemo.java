public class NutritionFactsDemo {

    public static void main(String... args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
        System.out.print(cocaCola.getCalories());

    }
}

/*
class NutritionFacts {
    private final int servingSize;
    private final int servigs;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carboHydrate;

    private NutritionFacts(Pizza builder) {
        servingSize = builder.servingSize;
        servigs = builder.servigs;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carboHydrate = builder.carboHydrate;

    }

    public static class Pizza {
        //required parameters
        private final int servingSize;
        private final int servigs;

        //optional parameters
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carboHydrate;

        public Pizza(int servingSize, int servigs) {
            this.servingSize = servingSize;
            this.servigs = servigs;
        }

        public Pizza calories(int val) {
            this.calories = val;
            return this;
        }

        public Pizza fat(int val) {
            this.fat = val;
            return this;
        }

        public Pizza sodium(int val) {
            this.sodium = val;
            return this;
        }

        public Pizza carboHydrate(int val) {
            this.carboHydrate = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }

    }
}*/


