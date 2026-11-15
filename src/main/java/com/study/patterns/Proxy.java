package com.study.patterns;

public class Proxy {
    public static String demo() {
        int[] calls = {0};
        Catalog proxy =
                new CacheProxy(
                        id -> {
                            calls[0]++;
                            return "Товар " + id;
                        });
        proxy.find(1);
        proxy.find(1);
        return "Запросов к источнику: " + calls[0];
    }

    interface Catalog {
        String find(int id);
    }

    static class CacheProxy implements Catalog {
        final Catalog target;
        final java.util.Map<Integer, String> cache = new java.util.HashMap<>();

        CacheProxy(Catalog target) {
            this.target = target;
        }

        public String find(int id) {
            return cache.computeIfAbsent(id, target::find);
        }
    }
}
