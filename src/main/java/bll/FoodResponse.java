package bll;

import java.util.List;

public class FoodResponse extends Response{
    public Food food;
    public List<Food> foods;

    public FoodResponse(boolean success, String message, Food food) {
        super(success, message);
        this.food = food;
    }

    public FoodResponse(boolean success, String message, List<Food> foods) {
        super(success, message);
        this.foods = foods;
    }
}
