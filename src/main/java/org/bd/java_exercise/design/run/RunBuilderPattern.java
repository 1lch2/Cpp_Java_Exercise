package org.bd.java_exercise.design.run;

import org.bd.java_exercise.design.builder.NutritionFacts;

public class RunBuilderPattern {

    public static void main(String[] args) {
        NutritionFacts coke = new NutritionFacts.Builder(200, 8)
                .fat(0)
                .sodium(0)
                .build();
        System.out.println(coke.toString());
    }
}
