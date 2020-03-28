package design.ImplementHashTable_SeparateChaining;

public class HashTableSeparateChaining<Key, Value> {
    private int M = 97;
    private Object[] st = new Object[M];

    private class Node {
        Key key;
        Value value;
        Node next;

        Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(Key key, Value value) {
        int hash = hash(key);
        for (Node node = (Node) st[hash]; node != null; node = node.next) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        st[hash] = new Node(key, value, (Node) st[hash]);
    }

    public Value get(Key key) {
        Node node = (Node) st[hash(key)];
        while (node != null) {
            if (node.key.equals(key)) return node.value;
            node = node.next;
        }
        return null;
    }

    public void remove(Key key) {
        int hash = hash(key);
        if (st[hash] == null) return;
        Node prev = null;
        for (Node node = (Node) st[hash]; node != null; node = node.next) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    st[hash] = node.next;
                } else {
                    prev.next = node.next;
                }
                return;
            }
            prev = node;
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
}
