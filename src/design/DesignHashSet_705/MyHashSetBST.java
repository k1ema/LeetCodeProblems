package design.DesignHashSet_705;
/**
 * 705. Design HashSet
 * https://leetcode.com/problems/design-hashset/
 *
 * Design a HashSet without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 * add(value): Insert a value into the HashSet.
 * contains(value) : Return whether the value exists in the HashSet or not.
 * remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
 *
 * Example:
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // returns true
 * hashSet.contains(3);    // returns false (not found)
 * hashSet.add(2);
 * hashSet.contains(2);    // returns true
 * hashSet.remove(2);
 * hashSet.contains(2);    // returns false (already removed)
 *
 * Note:
 * All values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashSet library.
 */
public class MyHashSetBST {
    // tc O(log(M/K)), where M - number of all possible values and K is a number of predefined buckets
    // sc O(M + K)
    // 13 ms, faster than 79.74%; 46.4 MB, less than 62.39%
    private int keyRange;
    private Bucket[] buckets;

    /** Initialize your data structure here. */
    public MyHashSetBST() {
        keyRange = 769;
        buckets = new Bucket[keyRange];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }
    }

    public void add(int key) {
        int hash = hash(key);
        buckets[hash].insert(key);
    }

    public void remove(int key) {
        int hash = hash(key);
        buckets[hash].delete(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = hash(key);
        return buckets[hash].contains(key);
    }

    private int hash(int key) {
        return key % keyRange;
    }

    private class Bucket {
        private BST bst;

        Bucket() {
            bst = new BST();
        }

        void insert(int key) {
            bst.insert(key);
        }

        void delete(int key) {
            bst.delete(key);
        }

        boolean contains(int key) {
            return bst.contains(key);
        }
    }

    private class BST {
        private Node root;

        void insert(int val) {
            root = insertIntoBST(root, val);
        }

        boolean contains(int val) {
            Node node = root;
            while (node != null) {
                if (val == node.val) return true;
                if (val < node.val) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            return false;
        }

        void delete(int val) {
            root = deleteFromBST(root, val);
        }

        private Node insertIntoBST(Node root, int val) {
            if (root == null) return new Node(val);
            if (val < root.val) {
                root.left = insertIntoBST(root.left, val);
            } else if (val > root.val) {
                root.right = insertIntoBST(root.right, val);
            }
            return root;
        }

        private Node deleteFromBST(Node root, int val) {
            if (root == null) return null;
            if (val == root.val) {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }
                Node min = findMin(root.right);
                root.val = min.val;
                root.right = deleteFromBST(root.right, min.val);
            } else if (val < root.val) {
                root.left = deleteFromBST(root.left, val);
            } else {
                root.right = deleteFromBST(root.right, val);
            }
            return root;
        }

        private Node findMin(Node root) {
            while (root != null && root.left != null) {
                root = root.left;
            }
            return root;
        }
    }

    private class Node {
        private int val;
        private Node left, right;

        Node(int val) {
            this.val = val;
        }
    }
}
