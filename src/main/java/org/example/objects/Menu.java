package org.example.objects;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Menu {
    private static final Burger ALL_IN_BURGER =
            new Burger("All in burger",
                    new LinkedList<>(Arrays.asList(Ingredient.BUN, Ingredient.ANGUS_BEEF_PATTY, Ingredient.SALAD,
                            Ingredient.CHEDDAR, Ingredient.HOMEMADE_SAUCE, Ingredient.BUN)));

    private static final Burger VEGAN_BEAN_BURGER =
            new Burger("Vegan bean burger",
                    new LinkedList<>(Arrays.asList(Ingredient.WHOLE_GRAIN_BUN, Ingredient.VEGAN_BEAN_PATTY, Ingredient.SALAD,
                            Ingredient.TOMATO, Ingredient.VEGAN_CHEESE, Ingredient.VEGAN_SAUCE, Ingredient.WHOLE_GRAIN_BUN)));

    private static final Burger LIGHT_BEEF_BURGER =
            new Burger("Light beef burger",
                    new LinkedList<>(Arrays.asList(Ingredient.WHOLE_GRAIN_BUN, Ingredient.BEEF_PATTY, Ingredient.SALAD,
                            Ingredient.TOMATO, Ingredient.WHOLE_GRAIN_BUN)));

    private static final Burger CHEESEBURGER =
            new Burger("Cheeseburger",
                    new LinkedList<>(Arrays.asList(Ingredient.BUN, Ingredient.BEEF_PATTY,
                            Ingredient.TOMATO, Ingredient.CHEDDAR, Ingredient.BUN)));

    private static final Burger DOUBLE_CHEESY_BURGER =
            new Burger("Double cheese burger",
                    new LinkedList<>(Arrays.asList(Ingredient.BUN, Ingredient.BEEF_PATTY, Ingredient.SALAD,
                            Ingredient.TOMATO, Ingredient.CHEDDAR, Ingredient.BACON, Ingredient.CUCUMBER,
                            Ingredient.CHEESE_SAUCE, Ingredient.BUN)));

    private static final Burger MEAT_LOVER_BURGER =
            new Burger("Meat lover burger",
                    new LinkedList<>(Arrays.asList(Ingredient.BUN, Ingredient.BEEF_PATTY, Ingredient.BEEF_PATTY,
                            Ingredient.SALAD, Ingredient.TOMATO, Ingredient.CHEDDAR, Ingredient.CHEESE_SAUCE, Ingredient.BUN)));

    private static final Burger CHILLI_CHEESE_ANGUS =
            new Burger("Chilli cheese angus burger",
                    new LinkedList<>(Arrays.asList(Ingredient.BUN, Ingredient.ANGUS_BEEF_PATTY, Ingredient.SALAD,
                            Ingredient.TOMATO, Ingredient.CHEDDAR, Ingredient.CHILLI_CHEESE_SAUCE,
                            Ingredient.CUCUMBER, Ingredient.MUSHROOM, Ingredient.BACON, Ingredient.BUN)));

    private static final Burger IMPOSSIBLE_BURGER =
            new Burger("Impossible burger",
                    new LinkedList<>(Arrays.asList(Ingredient.BUN, Ingredient.ANGUS_BEEF_PATTY, Ingredient.SALAD,
                            Ingredient.TOMATO, Ingredient.CHEDDAR, Ingredient.BEEF_PATTY, Ingredient.CHILLI_CHEESE_SAUCE,
                            Ingredient.CUCUMBER, Ingredient.MUSHROOM, Ingredient.BACON, Ingredient.HOMEMADE_SAUCE,
                            Ingredient.BUN)));

    public static final List<Burger> BURGERS = Arrays.asList(ALL_IN_BURGER, VEGAN_BEAN_BURGER, LIGHT_BEEF_BURGER, CHEESEBURGER,
            DOUBLE_CHEESY_BURGER, MEAT_LOVER_BURGER, CHILLI_CHEESE_ANGUS, IMPOSSIBLE_BURGER);
}
