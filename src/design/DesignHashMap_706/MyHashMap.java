package design.DesignHashMap_706;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 706. Design HashMap
 * https://leetcode.com/problems/design-hashmap/
 *
 * Design a HashMap without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 *
 * put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
 * get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 *
 * Example:
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);
 * hashMap.put(2, 2);
 * hashMap.get(1);            // returns 1
 * hashMap.get(3);            // returns -1 (not found)
 * hashMap.put(2, 1);          // update the existing value
 * hashMap.get(2);            // returns 1
 * hashMap.remove(2);          // remove the mapping for 2
 * hashMap.get(2);            // returns -1 (not found)
 *
 * Note:
 * All keys and values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashMap library.
 */
public class MyHashMap {
    private static final int mod = 10000;
    private List<int[]>[] nums;

    /** Initialize your data structure here. */
    public MyHashMap() {
        nums = new LinkedList[mod];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = hash(key);
        if (nums[hash] == null) {
            nums[hash] = new LinkedList<>();
        }
        for (int[] pair : nums[hash]) {
            if (pair[0] == key) {
                pair[1] = value;
                return;
            }
        }
        nums[hash].add(new int[] {key, value});
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = hash(key);
        if (nums[hash] == null) return -1;
        for (int[] pair : nums[hash]) {
            if (pair[0] == key) return pair[1];
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = hash(key);
        if (nums[hash] == null) return;
        nums[hash].removeIf(pair -> pair[0] == key);
//        Iterator<int[]> it = nums[hash].iterator();
//        while (it.hasNext()) {
//            int[] pair = it.next();
//            if (pair[0] == key) it.remove();
//        }
    }

    private int hash(int key) {
        return key % mod;
    }
}
