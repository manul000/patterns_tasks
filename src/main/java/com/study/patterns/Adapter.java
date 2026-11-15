package com.study.patterns;

public class Adapter {
    public static String demo() {
        return new PaymentAdapter(new LegacyPaymentSystem()).pay(new java.math.BigDecimal("12.50"));
    }

    interface PaymentService {
        String pay(java.math.BigDecimal rubles);
    }

    static class LegacyPaymentSystem {
        String makePayment(int kopecks) {
            return "Оплачено копеек: " + kopecks;
        }
    }

    record PaymentAdapter(LegacyPaymentSystem old) implements PaymentService {
        public String pay(java.math.BigDecimal rubles) {
            return old.makePayment(rubles.movePointRight(2).intValueExact());
        }
    }
}
