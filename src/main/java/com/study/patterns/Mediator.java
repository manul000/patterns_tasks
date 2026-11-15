package com.study.patterns;

public class Mediator {
    public static String demo() {
        Chat chat = new Chat();
        User a = new User("A", chat), b = new User("B", chat);
        a.send("Привет");
        return b.inbox.toString();
    }

    static class Chat {
        java.util.List<User> users = new java.util.ArrayList<>();

        void send(User from, String text) {
            for (User u : users) if (u != from) u.inbox.add(from.name + ": " + text);
        }
    }

    static class User {
        final String name;
        final Chat chat;
        final java.util.List<String> inbox = new java.util.ArrayList<>();

        User(String name, Chat chat) {
            this.name = name;
            this.chat = chat;
            chat.users.add(this);
        }

        void send(String text) {
            chat.send(this, text);
        }
    }
}
