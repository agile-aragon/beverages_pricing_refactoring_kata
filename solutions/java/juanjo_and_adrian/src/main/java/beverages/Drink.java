package beverages;

import toppings.Topping;

import java.util.ArrayList;
import java.util.List;

public abstract class Drink implements Beverage {
    private List<Topping> toppingList = new ArrayList<>();

    @Override
    public double price() {
        return toppingList.stream()
                .map(Topping::price)
                .reduce(basePrice(), Double::sum);
    }

    public Drink with(Topping topping) {
        toppingList.add(topping);
        return this;
    }

    abstract double basePrice();
}
