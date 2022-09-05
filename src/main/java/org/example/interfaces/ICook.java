package org.example.interfaces;

import org.example.objects.Burger;
import org.example.objects.Cook;

public interface ICook {
    void handleExperience(int experience);

    void levelUp();

    void prepareOrderElement(Burger burger);

    void finishPreparation();

    boolean equals(Cook cook);
}
