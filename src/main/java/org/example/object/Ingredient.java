package org.example.object;

import lombok.Getter;

@Getter
public enum Ingredient {
    BUN(1),
    WHOLE_GRAIN_BUN(1),
    BEEF_PATTY(2),
    ANGUS_BEEF_PATTY(3),
    VEGAN_BEAN_PATTY(4),
    BACON(1),
    CUCUMBER(1),
    MUSHROOM(2),
    SALAD(1),
    TOMATO(1),
    CHEDDAR(1),
    VEGAN_CHEESE(1),
    HOMEMADE_SAUCE(2),
    CHILLI_CHEESE_SAUCE(1),
    CHEESE_SAUCE(1),
    VEGAN_SAUCE(3);


    private int complexityNumber;

    Ingredient(final int complexityNumber) {
        this.complexityNumber = complexityNumber;
    }
}
