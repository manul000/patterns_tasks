package com.study.patterns;

public class Strategy {
    public static String demo() {
        Order order = new Order(d -> d * 10);
        int courier = order.total(5);
        order.delivery = d -> 0;
        return "Курьер: " + courier + ", самовывоз: " + order.total(5);
    }

    interface Delivery {
        int price(int distance);
    }

    static class Order {
        Delivery delivery;

        Order(Delivery d) {
            delivery = d;
        }

        int total(int distance) {
            return delivery.price(distance);
        }
    }
}
