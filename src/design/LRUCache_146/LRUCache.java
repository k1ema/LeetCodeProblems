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
    // 15 ms, faster than 63.96%; 50 MB, less than 41.49%
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
    private ListNode head = new ListNode(-1, -1), tail = new ListNode(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    // tc O(1)
    public int get(int key) {
        int value = -1;
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            value = node.value;
            insert(node);
        }
        return value;
    }

    // tc O(1)
    public void put(int key, int value) {
        if (!map.containsKey(key) && map.size() >= capacity) {
            ListNode toRemove = tail.prev;
            tail.prev = toRemove.prev;
            toRemove.prev.next = tail;
            map.remove(toRemove.key);
        }
        ListNode node = new ListNode(key, value);
        insert(node);
        map.put(key, node);
    }

    // tc O(1)
    private void insert(ListNode node) {
        if (map.containsKey(node.key)) {
            ListNode toRemove = map.get(node.key);
            toRemove.prev.next = toRemove.next;
            toRemove.next.prev = toRemove.prev;
        }
        ListNode headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */