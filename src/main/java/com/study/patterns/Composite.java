package com.study.patterns;

public class Composite {
    public static String demo() {
        return "Размер дерева: "
                + new Directory(
                java.util.List.of(
                        new FileNode(5), new Directory(java.util.List.of(new FileNode(10)))))
                .size();
    }

    interface Node {
        int size();
    }

    record FileNode(int size) implements Node {
    }

    record Directory(java.util.List<Node> children) implements Node {
        public int size() {
            return children.stream().mapToInt(Node::size).sum();
        }
    }
}
