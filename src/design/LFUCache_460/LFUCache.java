package design.LFUCache_460;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * 460. LFU Cache
 * https://leetcode.com/problems/lfu-cache/
 *
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 *
 * Implement the LFUCache class:
 *
 * LFUCache(int capacity) Initializes the object with the capacity of the data structure.
 * int get(int key) Gets the value of the key if the key exists in the cache. Otherwise,
 * returns -1.
 * void put(int key, int value) Sets or inserts the value if the key is not already present.
 * When the cache reaches its capacity, it should invalidate the least frequently used
 * item before inserting a new item. For this problem, when there is a tie (i.e., two or
 * more keys with the same frequency), the least recently used key would be evicted.
 * Notice that the number of times an item is used is the number of calls to the get and
 * put functions for that item since it was inserted. This number is set to zero when the
 * item is removed.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example 1:
 * Input
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 *
 * Output
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 *
 * Explanation
 * LFUCache lFUCache = new LFUCache(2);
 * lFUCache.put(1, 1);
 * lFUCache.put(2, 2);
 * lFUCache.get(1);      // return 1
 * lFUCache.put(3, 3);   // evicts key 2
 * lFUCache.get(2);      // return -1 (not found)
 * lFUCache.get(3);      // return 3
 * lFUCache.put(4, 4);   // evicts key 1.
 * lFUCache.get(1);      // return -1 (not found)
 * lFUCache.get(3);      // return 3
 * lFUCache.get(4);      // return 4
 *
 * Constraints:
 * 0 <= capacity, key, value <= 104
 * At most 105 calls will be made to get and put.
 */
public class LFUCache {
    // my solution
    private static class ListNode {
        private int key, value;
        private int freq;
        private ListNode prev, next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private int capacity;
    private Map<Integer, ListNode> map;
    private Map<Integer, Pair<ListNode, ListNode>> freqMap;
    private int minFreq;

    // 15 ms, faster than 95.52%; 47.1 MB, less than 5.95%
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 1;
        map = new HashMap<>();
        freqMap = new HashMap<>();
        freqMap.put(1, initNewList());
    }

    // tc O(1)
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        ListNode node = map.get(key);
        updateFreqMap(node);
        return node.value;
    }

    // tc O(1)
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.value = value;
            updateFreqMap(node);
        } else {
            if (map.size() == capacity) {
                Pair<ListNode, ListNode> p = freqMap.get(minFreq);
                ListNode tail = p.getValue();
                map.remove(tail.prev.key);
                deleteFromList(tail.prev);
            }
            ListNode node = new ListNode(key, value);
            map.put(node.key, node);
            setListHead(freqMap.get(1), node);
            minFreq = 1;
        }
    }

    // tc O(1)
    private void updateFreqMap(ListNode node) {
        Pair<ListNode, ListNode> p = freqMap.get(node.freq);
        deleteFromList(node);
        node.freq++;
        if (p.getKey().next.key == -1 && minFreq == (node.freq - 1)) {
            minFreq = node.freq;
        }
        Pair<ListNode, ListNode> newPair = freqMap.getOrDefault(node.freq, initNewList());
        setListHead(newPair, node);
        freqMap.put(node.freq, newPair);
    }

    // tc O(1)
    private void deleteFromList(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    // tc O(1)
    private void setListHead(Pair<ListNode, ListNode> p, ListNode node) {
        ListNode head = p.getKey();
        ListNode next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    // tc O(1)
    private Pair<ListNode, ListNode> initNewList() {
        ListNode head = new ListNode(-1, -1);
        ListNode tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        return new Pair<>(head, tail);
    }
}
