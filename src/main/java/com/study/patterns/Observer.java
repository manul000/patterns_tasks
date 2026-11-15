package com.study.patterns;

public class Observer {
    public static String demo() {
        Stock s = new Stock();
        StringBuilder log = new StringBuilder();
        s.listeners.add(v -> log.append("Остаток: ").append(v));
        s.update(7);
        return log.toString();
    }

    interface Listener {
        void changed(int value);
    }

    static class Stock {
        final java.util.List<Listener> listeners = new java.util.ArrayList<>();

        void update(int count) {
            listeners.forEach(l -> l.changed(count));
        }
    }
}
