package tree.PathSum_II_113;

import tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 113. Path Sum II
 * https://leetcode.com/problems/path-sum-ii/
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 *
 * Return:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class Solution {
    // 2 ms, faster than 36.89%; 37.9 MB, less than 100.00%
    // https://leetcode.com/problems/path-sum-ii/discuss/36683/DFS-with-one-LinkedList-accepted-java-solution
    List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root, sum, res, path);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> res, LinkedList<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new LinkedList<>(list));
        } else {
            dfs(root.left, sum - root.val, res, list);
            dfs(root.right, sum - root.val, res, list);
        }
        list.removeLast();
    }

    // keep track of all paths and add to result list only valid ones
    // 3 ms, faster than 13.88%; 40.5 MB, less than 13.63%
    List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> path = new ArrayList<>();
        pathSumRecursive(root, sum, res, path);
        return res;
    }

    private void pathSumRecursive(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                list.add(root.val);
                res.add(list);
            }
            return;
        }
        pathSumRecursive(root.left, sum - root.val, res, addToList(list, root.val));
        pathSumRecursive(root.right, sum - root.val, res, addToList(list, root.val));
    }

    private List<Integer> addToList(List<Integer> list, int val) {
        List<Integer> res = new ArrayList<>(list);
        res.add(val);
        return res;
    }

    // tc O(n), sc O(n)
    // my solution, start keeping track from leaf and after dfs done create result list by iterating stack
    // 4 ms	39.1 MB
    List<List<Integer>> pathSum1(TreeNode root, int sum) {
        if (root == null) return Collections.emptyList();
        List<Stack<Integer>> list = new ArrayList<>();
        dfs(root, sum, 0, list);
        List<List<Integer>> ans = new ArrayList<>();
        for (Stack<Integer> stack : list) {
            List<Integer> l = new ArrayList<>();
            while (!stack.isEmpty()) l.add(stack.pop());
            ans.add(l);
        }
        return ans;
    }

    private boolean dfs(TreeNode root, int sum, int curSum, List<Stack<Integer>> list) {
        if (root == null) return false;
        curSum += root.val;
        if (root.left == null && root.right == null && curSum == sum) {
            Stack<Integer> stack = new Stack<>();
            stack.push(root.val);
            list.add(stack);
            return true;
        } else {
            boolean left = dfs(root.left, sum, curSum, list);
            if (left) {
                for (Stack<Integer> stack : list) {
                    stack.push(root.val);
                }
            }
            List<Stack<Integer>> rightList = new ArrayList<>();
            boolean right = dfs(root.right, sum, curSum, rightList);
            if (right) {
                for (Stack<Integer> stack : rightList) {
                    stack.push(root.val);
                }
            }
            list.addAll(rightList);
            return left || right;
        }
    }
}
