package com.study.patterns;

public class Iterator {
    public static String demo() {
        var result = new java.util.ArrayList<Integer>();
        for (int i : new Tree(2, new Tree(1, null, null), new Tree(3, null, null))) result.add(i);
        return result.toString();
    }

    record Tree(int value, Tree left, Tree right) implements Iterable<Integer> {
        static void visit(Tree t, java.util.List<Integer> out) {
            if (t == null) return;
            visit(t.left, out);
            out.add(t.value);
            visit(t.right, out);
        }

        public java.util.Iterator<Integer> iterator() {
            java.util.List<Integer> values = new java.util.ArrayList<>();
            visit(this, values);
            return values.iterator();
        }
    }
}
