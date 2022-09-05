package org.example.threads;

import org.example.BurgerApp;
import org.example.interfaces.IOrderGenerator;
import org.example.objects.Kitchen;

import java.util.concurrent.TimeUnit;

public class OrderGeneratorThread extends Thread {
    private static final int INITIAL_DELAY = 0;
    private static final int DELAY = 10_000;
    private static final TimeUnit DELAY_TIME_UNIT = TimeUnit.MILLISECONDS;


    private final Kitchen kitchen;

    public OrderGeneratorThread(final Kitchen kitchen) {
        this.kitchen = kitchen;

        BurgerApp.EXECUTOR.scheduleWithFixedDelay(this, INITIAL_DELAY, DELAY, DELAY_TIME_UNIT);
    }

    @Override
    public void run() {
        kitchen.placeAnOrder(IOrderGenerator.generateAnOrder());
    }
}
