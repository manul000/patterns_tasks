package com.study.patterns;

public class Command {
    public static String demo() {
        var text = new StringBuilder("A");
        Action c = new Append(text, "B");
        c.execute();
        String before = text.toString();
        c.undo();
        return before + " -> undo -> " + text;
    }

    interface Action {
        void execute();

        void undo();
    }

    static class Append implements Action {
        final StringBuilder text;
        final String value;

        Append(StringBuilder text, String value) {
            this.text = text;
            this.value = value;
        }

        public void execute() {
            text.append(value);
        }

        public void undo() {
            text.setLength(text.length() - value.length());
        }
    }
}
