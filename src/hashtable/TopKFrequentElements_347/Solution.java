package hashtable.TopKFrequentElements_347;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class Solution {
    // tc O(n), sc O(n)
    // Bucket sort
    // https://leetcode.com/problems/top-k-frequent-elements/discuss/81602/Java-O(n)-Solution-Bucket-Sort
    // 13 ms, faster than 70.85%; 40.2 MB, less than 71.55%
    List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }

    // tc O(n), sc O(n)
    // 43 ms, faster than 40.71%; 41.7 MB, less than 14.65%
    List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }
        int[] a = new int[map.size()];
        int i = 0;
        for (int num : map.values()) {
            a[i++] = num;
        }

        int kth = findKthElement(a, k);
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= kth) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    private int findKthElement(int[] nums, int k) {
        int n = nums.length;
        k = n - k;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if (k > j) {
                lo = j + 1;
            } else if (k < j) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private Random rnd = new Random();
    private int partition(int[] nums, int lo, int hi) {
        int pInd = lo + rnd.nextInt(hi - lo + 1);
        int pivot = nums[pInd];
        swap(nums, pInd, lo);

        int i = lo, j = hi;
        while (i < j) {
            while (i <= j && nums[i] <= pivot) i++;
            while (i <= j && nums[j] > pivot) j--;
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
