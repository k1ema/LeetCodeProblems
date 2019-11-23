package design.ImplementRedBlackTree;

public class Node<Key extends Comparable<Key>, Value> {
    static final boolean RED = true;
    static final boolean BLACK = false;

    Key key;
    Value value;
    Node<Key, Value> left, right;
    boolean color;
    int count;

    Node(Key key, Value value, boolean color) {
        this.key = key;
        this.value = value;
        this.color = color;
        count = 1;
    }

    static boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    int size() {
        return count;
    }

    @Override
    public String toString() {
        return String.format("[%s %s %s %d]", key, value, color ? "RED" : "BLACK", count);
    }
}
