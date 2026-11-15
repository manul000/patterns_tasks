package com.study.patterns;

public class Singleton {
    public static String demo() {
        return "Один Config: " + (Config.get() == Config.get());
    }

    public static final class Config {
        private Config() {
        }

        public static Config get() {
            return Holder.INSTANCE;
        }

        private static class Holder {
            static final Config INSTANCE = new Config();
        }
    }
}
