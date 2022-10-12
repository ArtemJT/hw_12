package ua.hillel.coffee.order;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class CoffeeOrderBoard {

    private final Map<Integer, Order> orders = new TreeMap<>();

    public void add(String clientName) {
        int countOrders = !orders.isEmpty() ? orders.size() : 0;
        orders.put(++countOrders, new Order(countOrders, clientName));
    }

    public void deliver() {
        if (isEmpty()) return;

        int lastNumberOfOrder = new TreeSet<>(orders.keySet()).last();
        getAndRemove(lastNumberOfOrder);
        System.out.println("--------------");
    }

    public void deliver(int orderNumber) {
        if (isEmpty()) return;

        try {
            getAndRemove(orderNumber);
        } catch (NullPointerException e) {
            String message = "ORDER WAS DELIVERED";
            System.out.printf("%04d: %s%n", orderNumber, message);
        }
        System.out.println("~~~~~~~~~~~~~~");
    }

    public void draw() {
        String heading1 = "Num";
        String heading2 = "Name";
        String formatPattern = "%4s | %s %n";

        System.out.println("ORDER BOARD\n==============");
        System.out.printf(formatPattern, heading1, heading2);
        for (Order order : orders.values()) {
            String number = String.format("%04d", order.orderNumber());
            System.out.printf(formatPattern, number, order.clientName());
        }
    }

    private boolean isEmpty() {
        if (orders.isEmpty()) {
            System.out.println("ORDER LIST IS EMPTY!");
            return true;
        }
        return false;
    }

    private void getAndRemove(int number) {
        Order order = orders.get(number);
        orders.remove(number);
        System.out.printf("Order # %04d delivered to %s%n", order.orderNumber(), order.clientName());
    }
}
