package tree.AllElementsInTwoBinarySearchTrees_1305;

import tree.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1305. All Elements in Two Binary Search Trees
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 *
 * Given two binary search trees root1 and root2.
 *
 * Return a list containing all the integers from both trees sorted in ascending order.
 *
 * Example 1:
 * Input: root1 = [2,1,4], root2 = [1,0,3]
 * Output: [0,1,1,2,3,4]
 *
 * Example 2:
 * Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * Output: [-10,0,0,1,2,5,7,10]
 *
 * Example 3:
 * Input: root1 = [], root2 = [5,1,7,0,2]
 * Output: [0,1,2,5,7]
 *
 * Example 4:
 * Input: root1 = [0,-10,10], root2 = []
 * Output: [-10,0,10]
 *
 * Example 5:
 * Input: root1 = [1,null,8], root2 = [8,1]
 * Output: [1,1,8,8]
 *
 * Constraints:
 * Each tree has at most 5000 nodes.
 * Each node's value is between [-10^5, 10^5].
 */
public class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        dfs(root1, queue1);
        dfs(root2, queue2);
        List<Integer> res = new LinkedList<>();
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (queue1.peek() <= queue2.peek()) {
                res.add(queue1.poll());
            } else {
                res.add(queue2.poll());
            }
        }
        while (!queue1.isEmpty()) {
            res.add(queue1.poll());
        }
        while (!queue2.isEmpty()) {
            res.add(queue2.poll());
        }
        return res;
    }

    private void dfs(TreeNode root, Queue<Integer> queue) {
        if (root == null) return;
        dfs(root.left, queue);
        queue.add(root.val);
        dfs(root.right, queue);
    }
}
