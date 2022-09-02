package org.example.inetrface;

import org.example.object.Burger;
import org.example.object.Cook;

public interface ICook {
    void handleExperience(int experience);

    void levelUp();

    void prepareOrderElement(Burger burger);

    void finishPreparation();

    boolean equals(Cook cook);
}
