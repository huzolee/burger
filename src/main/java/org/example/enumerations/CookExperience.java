package org.example.enumerations;

import lombok.Getter;
import org.example.BurgerApp;

import java.util.Arrays;

@Getter
public enum CookExperience {
    LOW(5), MID(10), HIGH(15);

    public static final int EXPERIENCE_TO_LEVEL_UP = 10;
    private final int numberOfIngredients;

    CookExperience(final int numberOfIngredients) {
        this.numberOfIngredients = numberOfIngredients;
    }

    public static CookExperience levelUp(final CookExperience cookExperience) {
        switch (cookExperience) {
            case LOW:
                return MID;
            case MID:
            case HIGH:
                return HIGH;

            default:
                return LOW;
        }
    }

    public static CookExperience getRandomCookExperience() {
        final int cookExpIndex = BurgerApp.RANDOM.nextInt(3);
        return Arrays.asList(CookExperience.values()).get(cookExpIndex);
    }
}
