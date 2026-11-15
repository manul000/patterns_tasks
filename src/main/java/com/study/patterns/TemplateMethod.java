package com.study.patterns;

public class TemplateMethod {
    public static String demo() {
        return new Report() {
            String load() {
                return "данные";
            }

            String format() {
                return " [CSV]";
            }
        }.generate();
    }

    abstract static class Report {
        final String generate() {
            return header() + load() + format();
        }

        String header() {
            return "Отчёт: ";
        }

        abstract String load();

        abstract String format();
    }
}
