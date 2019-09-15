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
    // 64 ms, faster than 37.24%; 57.6 MB, less than 61.35%
    private class CashItem {
        CashItem prev;
        CashItem next;
        int key;
        int value;
        CashItem(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("[%d,%d]", key, value);
        }
    }

    private int capacity;
    private Map<Integer, CashItem> data = new HashMap<>();
    private CashItem head = new CashItem(-1, -1);
    private CashItem tail = new CashItem(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    // tc O(1)
    public int get(int key) {
        int value = -1;
        if (data.containsKey(key)) {
            CashItem cashItem = data.get(key);
            value = cashItem.value;
            insert(cashItem);
        }
        return value;
    }

    // tc O(1)
    public void put(int key, int value) {
        if (data.containsKey(key)) {
            // move to the head
            CashItem cashItem = data.get(key);
            // set new value
            cashItem.value = value;
            data.put(key, cashItem);
            insert(cashItem);
        } else {
            if (data.size() >= capacity) {
                // remove last one and put new
                data.remove(tail.prev.key);
                CashItem prev = tail.prev.prev;
                prev.next = tail;
                tail.prev = prev;
            }
            CashItem newItem = new CashItem(key, value);
            insert(newItem);
            data.put(key, newItem);
        }
    }

    private void insert(CashItem newItem) {
        CashItem prev = newItem.prev;
        if (prev != null) {
            // remove from double linked list
            prev.next = newItem.next;
            newItem.next.prev = prev;
        }
        // insert to the 1st position
        newItem.prev = head;
        head.next.prev = newItem;
        newItem.next = head.next;
        head.next = newItem;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */