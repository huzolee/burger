package org.example;

import org.example.enumeration.CookExperience;
import org.example.object.Cook;
import org.example.object.Kitchen;
import org.example.thread.OrderGeneratorThread;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;

public class BurgerApp {
    private static final int NUMBER_OF_COOKS = 3;

    public static final Random RANDOM = new Random();
    public static final ScheduledExecutorService EXECUTOR = Executors.newSingleThreadScheduledExecutor();

    public static void main(final String[] args) {
        new BurgerApp();
    }

    private BurgerApp() {
        final List<Cook> cooks = new LinkedList<>();
        final Kitchen kitchen = new Kitchen();

        addDifferentCooksToList(cooks);
        System.out.println("cooks: " + cooks + "\n");

        cooks.forEach((cook) -> {
            kitchen.applyCook(cook);
        });

        new OrderGeneratorThread(kitchen);

        Runtime.getRuntime().addShutdownHook(new Thread(EXECUTOR::shutdown));
    }

    private static Cook generateCook() {
        final List<String> cookNames = Arrays.asList("Jani", "Franka", "Zoli", "Adam", "Anna", "Panna", "Hanna");
        final int randomCookNameIndex = BurgerApp.RANDOM.nextInt(cookNames.size());
        final String cookName = cookNames.get(randomCookNameIndex);

        return new Cook(cookName, CookExperience.getRandomCookExperience());
    }

    private void addDifferentCooksToList(final List<Cook> cooks) {
        for (int i = 0; i < NUMBER_OF_COOKS; i++) {
            Cook cook = null;

            while (cook == null) {
                final Cook tempCook = BurgerApp.generateCook();
                final List<Cook> filteredList = cooks.stream()
                        .filter(c -> c.equals(tempCook))
                        .collect(Collectors.toList());

                if (filteredList.isEmpty()) {
                    cook = tempCook;
                }
            }

            cooks.add(cook);
        }
    }
}
