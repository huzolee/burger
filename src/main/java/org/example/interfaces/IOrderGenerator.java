package org.example.interfaces;

import org.example.BurgerApp;
import org.example.objects.Burger;
import org.example.objects.Menu;
import org.example.objects.Order;

import java.util.LinkedList;

public interface IOrderGenerator {
    int maximumNumberOfOrderElement = 7;

    static Order generateAnOrder() {
        final int numberOfBurgersInOrder = BurgerApp.RANDOM.nextInt(maximumNumberOfOrderElement) + 1;
        final int maxIndex = Menu.BURGERS.size() - 1;
        final LinkedList<Burger> burgers = new LinkedList<>();

        for (int i = 0; i < numberOfBurgersInOrder; i++) {
            final int burgerIndex = BurgerApp.RANDOM.nextInt(maxIndex);
            final Burger burger = Menu.BURGERS.get(burgerIndex);

            burgers.add(burger);
        }

        return new Order(burgers);
    }
}
