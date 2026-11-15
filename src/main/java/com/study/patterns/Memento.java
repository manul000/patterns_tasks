package com.study.patterns;

public class Memento {
    public static String demo() {
        Editor e = new Editor();
        e.text = "Первая версия";
        Snapshot saved = e.save();
        e.text = "Изменения";
        e.restore(saved);
        return e.text;
    }

    record Snapshot(String text) {
    }

    static class Editor {
        String text = "";

        Snapshot save() {
            return new Snapshot(text);
        }

        void restore(Snapshot s) {
            text = s.text();
        }
    }
}
