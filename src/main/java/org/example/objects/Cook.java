package org.example.objects;

import lombok.Getter;
import lombok.Setter;
import org.example.enumerations.CookExperience;
import org.example.interfaces.ICook;
import org.example.services.CookService;

@Getter()
public class Cook implements ICook {

    private final CookService cookService;
    private final String name;
    @Setter
    private int experience = 0;
    @Setter
    private CookExperience cookExperience;

    public Cook(final String name, final CookExperience cookExperience) {
        this.name = name;
        this.cookExperience = cookExperience;
        cookService = new CookService(this);
    }

    public boolean isWorking() {
        return cookService.isWorking();
    }

    public boolean isNotWorking() {
        return !isWorking();
    }

    @Override
    public void handleExperience(final int gainedExperience) {
        this.cookService.handleExperience(gainedExperience);
    }

    @Override
    public void levelUp() {
        this.cookService.levelUp();
    }

    @Override
    public void prepareOrderElement(final Burger burger) {
        cookService.prepareOrderElement(burger);
    }

    @Override
    public boolean equals(final Cook cook) {
        return getName().equals(cook.getName());
    }

    @Override
    public void finishPreparation() {
        handleExperience(1);
        cookService.finishPreparation();
    }

    @Override
    public String toString() {
        return "Cook{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                ", cookExperience=" + cookExperience +
                '}';
    }
}
