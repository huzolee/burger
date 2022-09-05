package org.example.objects;

import lombok.Getter;
import org.example.interfaces.IKitchen;
import org.example.services.KitchenService;

@Getter
public class Kitchen implements IKitchen {

    private final KitchenService kitchenService;

    public Kitchen() {
        kitchenService = new KitchenService();
        kitchenService.checkOrders();
    }

    @Override
    public void applyCook(final Cook cook) {
        kitchenService.applyCook(cook);
    }

    @Override
    public void placeAnOrder(final Order order) {
        kitchenService.placeAnOrder(order);
    }
}
