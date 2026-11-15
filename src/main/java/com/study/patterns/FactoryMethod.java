package com.study.patterns;

public class FactoryMethod {
    public static String demo() {
        Creator word =
                new Creator() {
                    Document create() {
                        return new Word();
                    }
                };
        Creator pdf =
                new Creator() {
                    Document create() {
                        return new Pdf();
                    }
                };
        Creator excel =
                new Creator() {
                    Document create() {
                        return new Excel();
                    }
                };
        return word.export() + ", " + pdf.export() + ", " + excel.export();
    }

    interface Document {
        String format();
    }

    static class Word implements Document {
        public String format() {
            return "Word";
        }
    }

    static class Pdf implements Document {
        public String format() {
            return "PDF";
        }
    }

    static class Excel implements Document {
        public String format() {
            return "Excel";
        }
    }

    abstract static class Creator {
        abstract Document create();

        String export() {
            return create().format();
        }
    }
}
