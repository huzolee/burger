package org.example.threads;

import org.example.ConsoleColor;
import org.example.objects.Burger;
import org.example.objects.Cook;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CookThread extends Thread {
    private boolean burgerMakingInProgress = false;
    private LocalDateTime burgerPreparationTimeStart;
    private LocalDateTime burgerPreparationTimeEnd;
    private Burger burger;
    private final Cook cook;

    public CookThread(final Cook cook) {
        this.cook = cook;
    }

    @Override
    public void run() {
        burgerMakingInProgress();
        setBurgerPreparationTimeEnd();

        if (burgerMakingInProgress) {
            if (LocalDateTime.now().isAfter(burgerPreparationTimeEnd)) {
                System.out.println(ConsoleColor.GREEN + cook.getName() + " has finished \"" + burger.getName() + "\" preparation " + "\u2714 \n");
                System.out.println(ConsoleColor.RESET);

                burger = null;
                burgerMakingInProgress = false;
                cook.finishPreparation();
            }
        }
    }

    private void setBurgerPreparationTimeEnd() {
        if (burgerPreparationTimeStart != null && burgerPreparationTimeEnd == null) {
            burgerPreparationTimeEnd = burgerPreparationTimeStart.plus(burger.getPreparationTime(), ChronoUnit.SECONDS);
        }
    }

    private void burgerMakingInProgress() {
        if (!burgerMakingInProgress && burger != null) {
            burgerMakingInProgress = true;
            burgerPreparationTimeStart = LocalDateTime.now();
        }
    }

    public void setBurger(final Burger burger) {
        this.burger = burger;
    }

    public boolean isBurgerMakingInProgress() {
        return burgerMakingInProgress;
    }
}
