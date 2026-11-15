package com.study.patterns;

public class Bridge {
    public static String demo() {
        return new Circle(() -> "Круг SVG").draw() + ", " + new Circle(() -> "Круг Canvas").draw();
    }

    interface Renderer {
        String circle();
    }

    record Circle(Renderer renderer) {
        String draw() {
            return renderer.circle();
        }
    }
}
