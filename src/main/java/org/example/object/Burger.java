package org.example.object;

import lombok.Getter;

import java.util.HashSet;
import java.util.List;

@Getter
public class Burger {
    private final String name;
    private final List<Ingredient> ingredients;

    public Burger(final String name, final List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "name='" + name + '\'' +
                ", complexity=" + getComplexity() +
                '}';
    }

    public int getComplexity() {
        return new HashSet<>(getIngredients()).size();
    }

    public int getPreparationTime() {
        return ingredients.stream().map(Ingredient::getComplexityNumber).reduce(0, Integer::sum);
    }
}
