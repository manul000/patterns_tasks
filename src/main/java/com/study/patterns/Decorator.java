package com.study.patterns;

public class Decorator {
    public static String demo() {
        return "Кофе + молоко + сироп: " + new Syrup(new Milk(new Coffee())).price();
    }

    interface Drink {
        int price();
    }

    record Coffee() implements Drink {
        public int price() {
            return 100;
        }
    }

    record Milk(Drink base) implements Drink {
        public int price() {
            return base.price() + 30;
        }
    }

    record Syrup(Drink base) implements Drink {
        public int price() {
            return base.price() + 20;
        }
    }
}
