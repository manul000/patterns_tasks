package com.study.patterns;

public class AbstractFactory {
    public static String demo() {
        return java.util.stream.Stream.of("Windows", "Mac", "Linux")
                .map(Factory::new)
                .map(f -> f.button().render() + " + " + f.checkbox().render())
                .collect(java.util.stream.Collectors.joining("; "));
    }

    interface Button {
        String render();
    }

    interface Checkbox {
        String render();
    }

    interface UiFactory {
        Button button();

        Checkbox checkbox();
    }

    record Factory(String os) implements UiFactory {
        public Button button() {
            return () -> os + " button";
        }

        public Checkbox checkbox() {
            return () -> os + " checkbox";
        }
    }
}
