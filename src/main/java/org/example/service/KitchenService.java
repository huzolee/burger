package org.example.service;

import lombok.Getter;
import org.example.BurgerApp;
import org.example.object.Cook;
import org.example.object.Order;
import org.example.thread.KitchenThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

@Getter
public class KitchenService {

    private static final int INITIAL_DELAY = 0;
    private static final int DELAY = 5_000;
    private static final TimeUnit TIME_UNIT = TimeUnit.MILLISECONDS;

    private final KitchenThread kitchenThread;
    private final List<Cook> cooks = new ArrayList<>();
    private final ConcurrentLinkedDeque<Order> orders = new ConcurrentLinkedDeque<>();
    private int numberOfOrders;

    public KitchenService() {
        this.numberOfOrders = 0;
        kitchenThread = new KitchenThread(this);
    }

    public void checkOrders() {
        BurgerApp.EXECUTOR.scheduleWithFixedDelay(kitchenThread, INITIAL_DELAY, DELAY, TIME_UNIT);
    }

    public void applyCook(final Cook cook) {
        this.cooks.add(cook);
    }

    public void placeAnOrder(final Order order) {
        orders.add(order);
        this.numberOfOrders++;

        System.out.println("order arrived to kitchen " + order);
        System.out.println("remained orders " + orders + "\n");
    }
}
