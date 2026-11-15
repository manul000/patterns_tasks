package com.study.patterns;

public class Flyweight {
    public static String demo() {
        Styles styles = new Styles();
        Character a = new Character('A', 0, styles.get("Arial", 12)),
                b = new Character('B', 1, styles.get("Arial", 12));
        return "Общий стиль: " + (a.shared() == b.shared());
    }

    record GlyphStyle(String font, int size) {
    }

    static class Styles {
        final java.util.Map<String, GlyphStyle> cache = new java.util.HashMap<>();

        GlyphStyle get(String font, int size) {
            return cache.computeIfAbsent(font + ":" + size, k -> new GlyphStyle(font, size));
        }
    }

    record Character(char value, int x, GlyphStyle shared) {
    }
}
