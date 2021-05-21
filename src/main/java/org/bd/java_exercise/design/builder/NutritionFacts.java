package org.bd.java_exercise.design.builder;

/**
 * 建造器（Builder）模式
 */
public class NutritionFacts {

    private final int servingSize;  // Required
    private final int calories;     // Required
    private final int fat;          // Optional
    private final int sodium;       // Optional

    public static class Builder {

        // Required
        private final int servingSize;
        private final int calories;

        // Optional
        private int fat = 0;
        private int sodium = 0;

        // Constructor with required parameters
        public Builder(int servingSize, int calories) {
            this.servingSize = servingSize;
            this.calories = calories;
        }

         public Builder fat(int val) {
            fat = val;
            return this;
         }

         public Builder sodium(int val) {
            sodium = val;
            return this;
         }

         public NutritionFacts build() {
            return new NutritionFacts(this);
         }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
    }

    @Override
    public String toString() {
        return "servingSize: " + this.servingSize
                + ", calories: " + this.calories
                + ", fat: " + this.fat
                + ", sodium: " + this.sodium;
    }
}
