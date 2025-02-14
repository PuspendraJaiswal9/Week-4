package personalizedmealplangenerator;

// MealPlan Interface
interface MealPlan {
    String getMealType();
    String getMealDetails();
}

// Specific Meal Types
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegetarian";
    }

    @Override
    public String getMealDetails() {
        return "Includes vegetables, grains, and dairy.";
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegan";
    }

    @Override
    public String getMealDetails() {
        return "Includes plant-based foods only, no animal products.";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Keto";
    }

    @Override
    public String getMealDetails() {
        return "Includes high fats, moderate protein, and low carbs.";
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "High-Protein";
    }

    @Override
    public String getMealDetails() {
        return "Includes high-protein sources like chicken, eggs, and legumes.";
    }
}

// Generic Meal Class
class Meal<T extends MealPlan> {
    private T mealType;

    public Meal(T mealType) {
        this.mealType = mealType;
    }

    public T getMealType() {
        return mealType;
    }

    public void displayMealInfo() {
        System.out.println("Meal Type: " + mealType.getMealType());
        System.out.println("Details: " + mealType.getMealDetails());
        System.out.println();
    }
}

// Utility Class for Meal Validation & Generation
class MealPlanGenerator {
    public static <T extends MealPlan> void generateMealPlan(Meal<T> meal) {
        System.out.println("Generating Meal Plan...");
        meal.displayMealInfo();
    }
}

// Main Class
public class PersonalizedMealPlanner {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = new Meal<>(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal());
        Meal<KetoMeal> ketoMeal = new Meal<>(new KetoMeal());
        Meal<HighProteinMeal> proteinMeal = new Meal<>(new HighProteinMeal());

        System.out.println("Personalized Meal Plans:");
        MealPlanGenerator.generateMealPlan(vegMeal);
        MealPlanGenerator.generateMealPlan(veganMeal);
        MealPlanGenerator.generateMealPlan(ketoMeal);
        MealPlanGenerator.generateMealPlan(proteinMeal);
    }
}

