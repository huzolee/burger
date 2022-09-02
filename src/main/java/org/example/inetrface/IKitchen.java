package org.example.inetrface;

import org.example.object.Cook;
import org.example.object.Order;

public interface IKitchen {
    void applyCook(Cook cook);

    void placeAnOrder(Order order);
}
