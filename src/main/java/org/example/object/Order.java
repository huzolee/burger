package org.example.object;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.UUID;

@Getter
public class Order {
    private UUID id;
    private LocalDateTime arrivedTime = LocalDateTime.now();
    private LinkedList<Burger> burgers;

    public Order(final LinkedList<Burger> burgers) {
        this.id = UUID.randomUUID();
        this.burgers = burgers;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", burgers=" + burgers +
                '}';
    }
}
