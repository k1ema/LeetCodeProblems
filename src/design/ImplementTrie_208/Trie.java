package design.ImplementTrie_208;

/**
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class Trie {
    private class Node {
        private char val;
        private Node[] links = new Node[26];
        private boolean isEnd;

        private Node() {}
        private Node(char val) {
            this.val = val;
        }

        void insert(Node node) {
            links[node.val - 'a'] = node;
        }

        Node get(char val) {
            return links[val - 'a'];
        }

        boolean containsKey(char val) {
            return links[val - 'a'] != null;
        }

        void setEnd() {
            isEnd = true;
        }

        boolean isEnd() {
            return isEnd;
        }
    }

    private Node root = new Node();

    // tc O(n), sc O(1)
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsKey(c)) {
                node.insert(new Node(c));
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    // tc O(n), sc O(1)
    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            node = node.get(word.charAt(i));
            if (node == null) return false;
        }
        return node.isEnd();
    }

    // tc O(n), sc O(1)
    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            node = node.get(prefix.charAt(i));
            if (node == null) return false;
        }
        return true;
    }
}
