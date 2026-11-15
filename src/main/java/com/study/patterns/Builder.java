package com.study.patterns;

public class Builder {
    public static String demo() {
        return new ProfileBuilder().name("Артём").city("СПб").age(20).build().toString();
    }

    record UserProfile(String name, String city, int age) {
    }

    static class ProfileBuilder {
        String name, city = "";
        int age;

        ProfileBuilder name(String v) {
            name = v;
            return this;
        }

        ProfileBuilder city(String v) {
            city = v;
            return this;
        }

        ProfileBuilder age(int v) {
            age = v;
            return this;
        }

        UserProfile build() {
            if (name == null || name.isBlank()) throw new IllegalArgumentException("name");
            return new UserProfile(name, city, age);
        }
    }
}
