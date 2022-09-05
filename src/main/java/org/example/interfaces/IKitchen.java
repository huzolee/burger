package org.example.interfaces;

import org.example.objects.Cook;
import org.example.objects.Order;

public interface IKitchen {
    void applyCook(Cook cook);

    void placeAnOrder(Order order);
}
