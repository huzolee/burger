package org.example.services;

import lombok.Getter;
import org.example.BurgerApp;
import org.example.ConsoleColor;
import org.example.enumerations.CookExperience;
import org.example.objects.Burger;
import org.example.objects.Cook;
import org.example.threads.CookThread;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Getter
public class CookService {

    private static final int INITIAL_DELAY = 0;
    private static final int DELAY = 1000;
    private static final TimeUnit TIME_UNIT = TimeUnit.MILLISECONDS;

    private final Cook cook;
    private final CookThread cookThread;
    private ScheduledFuture<?> scheduledFuture;

    public CookService(final Cook cook) {
        this.cook = cook;
        cookThread = new CookThread(cook);
    }

    public void handleExperience(final int gainedExperience) {
        final int exp = cook.getExperience() + gainedExperience;
        cook.setExperience(exp);

        if (exp >= CookExperience.EXPERIENCE_TO_LEVEL_UP) {
            levelUp();
        }
    }

    public void levelUp() {
        cook.setExperience(cook.getExperience() - CookExperience.EXPERIENCE_TO_LEVEL_UP);
        cook.setCookExperience(CookExperience.levelUp(cook.getCookExperience()));

        System.out.println(ConsoleColor.YELLOW_BOLD + "\u2605\u2605\u2605" + ConsoleColor.CYAN + cook.getName() + " leveled up to " + "\"" + cook.getCookExperience() + "\"" + ConsoleColor.YELLOW_BOLD + "\u2605\u2605\u2605");
        System.out.println(ConsoleColor.RESET);
    }

    public boolean isWorking() {
        return cookThread.isBurgerMakingInProgress();
    }

    public void prepareOrderElement(final Burger burger) {
        cookThread.setBurger(burger);
        scheduledFuture = BurgerApp.EXECUTOR.scheduleWithFixedDelay(cookThread, INITIAL_DELAY, DELAY, TIME_UNIT);
    }

    public void finishPreparation() {
        scheduledFuture.cancel(true);
    }
}
