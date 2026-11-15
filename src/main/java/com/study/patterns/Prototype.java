package com.study.patterns;

public class Prototype {
    public static String demo() {
        Sprite original = new Sprite("hero.png", 0, 0);
        return original + " -> " + original.copyAt(2, 3);
    }

    record Sprite(String image, int x, int y) {
        Sprite copyAt(int x, int y) {
            return new Sprite(image, x, y);
        }
    }
}
