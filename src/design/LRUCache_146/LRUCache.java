package design.LRUCache_146;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 * https://leetcode.com/problems/lru-cache/
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the
 * following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 * otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached
 * its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache(2);
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);      // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);      // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);      // returns -1 (not found)
 * cache.get(3);      // returns 3
 * cache.get(4);      // returns 4
 */
public class LRUCache {
    // 12 ms, faster than 95.31%; 47.5 MB, less than 8.83%
    private class ListNode {
        private int key, value;
        private ListNode prev;
        private ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private Map<Integer, ListNode> map;
    private ListNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    // tc O(1)
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        deleteFromList(node);
        setListHead(node);
        return node.value;
    }

    // tc O(1)
    public void put(int key, int value) {
        ListNode node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            deleteFromList(node);
        } else {
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                deleteFromList(tail.prev);
            }
            node = new ListNode(key, value);
            map.put(key, node);
        }
        setListHead(node);
    }

    private void deleteFromList(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void setListHead(ListNode node) {
        ListNode next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */