package com.study.patterns;

public class Facade {
    public static String demo() {
        return new PaymentFacade().pay(200);
    }

    static class Bank {
        boolean reserve(int value) {
            return value > 0;
        }
    }

    static class Receipt {
        String print(int value) {
            return "Чек: " + value;
        }
    }

    static class PaymentFacade {
        String pay(int amount) {
            if (!new Bank().reserve(amount)) throw new IllegalArgumentException();
            return new Receipt().print(amount);
        }
    }
}
