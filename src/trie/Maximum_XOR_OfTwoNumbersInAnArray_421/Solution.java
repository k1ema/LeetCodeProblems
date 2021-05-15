package trie.Maximum_XOR_OfTwoNumbersInAnArray_421;

/**
 * 421. Maximum XOR of Two Numbers in an Array
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 *
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 *
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 *
 * Could you do this in O(n) runtime?
 *
 * Example:
 * Input: [3, 10, 5, 25, 2, 8]
 * Output: 28
 *
 * Explanation: The maximum result is 5 ^ 25 = 28.
 */
public class Solution {
    // tc O(n), sc O(1)
    // 34 ms, faster than 85.28%; 49 MB, less than 5.05%
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for (int n : nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int v = (n >> i) & 1;
                if (node.children[v] == null) {
                    node.children[v] = new TrieNode();
                }
                node = node.children[v];
            }
            node.val = n;
        }

        int res = 0;
        for (int n : nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (n >> i) & 1;
                int toggleBit = (bit + 1) % 2;
                if (node.children[toggleBit] != null) {
                    node = node.children[toggleBit];
                } else {
                    node = node.children[bit];
                }
            }
            int curXor = n ^ node.val;
            res = Math.max(res, curXor);
        }
        return res;
    }

    private static class TrieNode {
        Integer val;
        TrieNode[] children;
        TrieNode() {
            children = new TrieNode[2];
        }
    }

    // tc O(n), sc O(1)
    // 33 ms, faster than 80.00%; 49.3 MB, less than 46.72%
    public int findMaximumXOR2(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode trie = root;
            for (int i = 31; i >= 0; i--) {
                int v = (num >> i) & 1;
                if (trie.children[v] == null) {
                    trie.children[v] = new TrieNode();
                }
                trie = trie.children[v];
            }
        }

        int maxXor = 0;
        for (int num : nums) {
            TrieNode trie = root;
            int curXor = 0;
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >> i) & 1;
                int toggleBit = (curBit + 1) % 2;
                if (trie.children[toggleBit] == null) {
                    toggleBit = curBit;
                }
                curXor = (curXor << 1) | (toggleBit ^ curBit);
                trie = trie.children[toggleBit];
                maxXor = Math.max(maxXor, curXor);
            }
        }

        return maxXor;
    }

    private class TrieNode1 {
        private TrieNode[] children = new TrieNode[2];
    }

    // brute force tc O(n^2), sc O(1)
    public int findMaximumXOR1(int[] nums) {
        int res = 0;
        for (int num : nums) {
            for (int num2 : nums) {
                res = Math.max(res, num ^ num2);
            }
        }
        return res;
    }
}
