package org.example.thread;

import org.example.ConsoleColor;
import org.example.object.Burger;
import org.example.object.Cook;
import org.example.object.Order;
import org.example.service.KitchenService;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Collectors;

public class KitchenThread extends Thread {
    private final List<Cook> cooks;
    private final ConcurrentLinkedDeque<Order> orders;
    private Order underProcessOrder;

    public KitchenThread(final KitchenService kitchenService) {
        cooks = kitchenService.getCooks();
        orders = kitchenService.getOrders();
    }

    @Override
    public void run() {
        setUnderProcessOrder();
        divideOrderToCooks();
    }

    private List<Cook> getAvailableCooks() {
        return cooks.stream().filter(Cook::isNotWorking).collect(Collectors.toList());
    }

    private boolean isOrderUnderProcess() {
        return underProcessOrder != null;
    }

    private void setUnderProcessOrder() {
        if (!isOrderUnderProcess()) {
            underProcessOrder = orders.pollFirst();
        }
    }

    private void divideOrderToCooks() {
        if (underProcessOrder != null) {
            final LinkedList<Burger> burgers = underProcessOrder.getBurgers();
            final Burger burger = burgers.peekFirst();

            if (burger != null) {
                final boolean assignSuccessful = addBurgerToSuitableCook(burger);

                if (assignSuccessful) {
                    burgers.pollFirst();

                    System.out.println("remained order elements " + underProcessOrder.getBurgers() + "\n");
                }
            }

            if (burgers.isEmpty()) {
                System.out.println(ConsoleColor.GREEN + "all burgers are in process in order \"" + underProcessOrder.getId() + "\"\n");
                System.out.println(ConsoleColor.RESET);
                underProcessOrder = null;
            }
        }
    }

    private boolean addBurgerToSuitableCook(final Burger burger) {
        final List<Cook> availableCooks = getAvailableCooks();
        final Optional<Cook> suitableCookOP = availableCooks.stream()
                .filter(cook -> cook.getCookExperience().getNumberOfIngredients() >= burger.getComplexity())
                .min(Comparator.comparing(Cook::getCookExperience));

        if (suitableCookOP.isPresent()) {
            final Cook suitableCook = suitableCookOP.get();
            final Cook cook = suitableCook;
            cook.prepareOrderElement(burger);

            System.out.println("available cooks: " + availableCooks);
            System.out.println("suitable cook " + suitableCook + "\n");
            System.out.println(ConsoleColor.YELLOW + "\u22B3 \"" + burger.getName() + "\" added for processing to " + cook.getName() + "\n");
            System.out.println(ConsoleColor.RESET);

            return true;
        }

        return false;
    }
}
