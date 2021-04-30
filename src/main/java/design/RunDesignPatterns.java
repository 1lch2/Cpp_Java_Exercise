package design;

public class RunDesignPatterns {

    public static void main(String[] args) {
        NutritionFacts coke = new NutritionFacts.Builder(200, 8)
                .fat(0)
                .sodium(0)
                .build();
        System.out.println(coke.toString());
    }
}
