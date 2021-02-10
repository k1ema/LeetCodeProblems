package design.ImplementRedBlackTree;

import java.util.LinkedList;
import java.util.List;

import static design.ImplementRedBlackTree.Node.BLACK;
import static design.ImplementRedBlackTree.Node.RED;
import static design.ImplementRedBlackTree.Node.isRed;

public class LeanLeftRedBlackTree<Key extends Comparable<Key>, Value> {
    private Node root;

    public LeanLeftRedBlackTree() {
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node<Key, Value> h, Key key, Value value) {
        if (h == null) return new Node<>(key, value, RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, value);
            h.count++;
        } else if (cmp > 0) {
            h.right = put(h.right, key, value);
            h.count++;
        } else {
            h.value = value;
        }

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        return h;
    }

    public Value get(Key key) {
        Node h = root;
        while (h != null) {
            int cmp = key.compareTo((Key) h.key);
            if (cmp < 0) h = h.left;
            else if (cmp > 0) h = h.right;
            else return (Value) h.value;
        }
        return null;
    }

    public Value min() {
        Node x = root;
        while (x.left != null) {
            x = x.left;
        }
        return (Value) x.value;
    }

    public Value max() {
        Node x = root;
        while (x.right != null) {
            x = x.right;
        }
        return (Value) x.value;
    }

    public Iterable<Key> keys() {
        List<Key> list = new LinkedList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(Node h, List<Key> list) {
        if (h == null) return;
        inorder(h.left, list);
        list.add((Key) h.key);
        inorder(h.right, list);
    }

    public boolean contains(Key key) {
        Node h = root;
        while (h != null) {
            int cmp = key.compareTo((Key) h.key);
            if (cmp < 0) h = h.left;
            else if (cmp > 0) h = h.right;
            else return true;
        }
        return false;
    }

    public int size() {
        return root.count;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private Node rotateLeft(Node h) {
        assert isRed(h.right);
        Node x = h.right;
        int h_count_new = 1 + (h.left != null ? h.left.count : 0) + (x.left != null ? x.left.count : 0);
        int x_count_new = 1 + h_count_new + (x.right != null ? x.right.count : 0);
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;

        h.count = h_count_new;
        x.count = x_count_new;

        return x;
    }

    private Node rotateRight(Node h) {
        assert isRed(h.left);
        Node x = h.left;
        int h_count_new = 1 + (x.right != null ? x.right.count : 0) + (h.right != null ? h.right.count : 0);
        int x_count_new = 1 + (x.left != null ? x.left.count : 0) + h_count_new;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;

        h.count = h_count_new;
        x.count = x_count_new;

        return x;
    }

    private void flipColors(Node h) {
        assert !isRed(h);
        assert isRed(h.left);
        assert isRed(h.right);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
}
