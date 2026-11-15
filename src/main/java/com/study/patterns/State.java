package com.study.patterns;

public class State {
    public static String demo() {
        Player p = new Player();
        return p.press() + " -> " + p.press();
    }

    interface PlayerState {
        String play(Player p);
    }

    static class Stopped implements PlayerState {
        public String play(Player p) {
            p.state = new Playing();
            return "Playing";
        }
    }

    static class Playing implements PlayerState {
        public String play(Player p) {
            p.state = new Stopped();
            return "Stopped";
        }
    }

    static class Player {
        PlayerState state = new Stopped();

        String press() {
            return state.play(this);
        }
    }
}
