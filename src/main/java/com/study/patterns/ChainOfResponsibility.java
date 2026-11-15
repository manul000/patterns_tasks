package com.study.patterns;

public class ChainOfResponsibility {
    public static String demo() {
        Handler auth =
                new Handler() {
                    String process(String s) {
                        return s.contains("token") ? null : "401";
                    }
                };
        auth.then(
                new Handler() {
                    String process(String s) {
                        return s.length() > 100 ? "413" : null;
                    }
                });
        return auth.handle("token GET /tasks");
    }

    abstract static class Handler {
        Handler next;

        Handler then(Handler h) {
            next = h;
            return h;
        }

        String handle(String request) {
            String result = process(request);
            return result != null ? result : next == null ? "OK" : next.handle(request);
        }

        abstract String process(String request);
    }
}
