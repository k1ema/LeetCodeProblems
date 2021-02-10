package dynamic.UniqueBinarySearchTrees_II_95;

import tree.utils.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 *
 * Given an integer n, generate all structurally unique BST's (binary search trees)
 * that store values 1 ... n.
 *
 * Example:
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 *
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class Solution {
    // https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/31494/A-simple-recursive-solution

    // this algorithm has next idea:
    //    for instance n=3, we call gen(1,3).
    //    it means we should select 1 as a root, and build all possible trees from the rest of sequence - [2,3] (call it sequence A)
    //    And make "for" loop each time creating new TreeNode(1) and connecting it with every tree from generated before.
    //    Sequence A is divided into two parts by selected root. For instance if root = 2, we have [1] and [3].
    //    This two sub-sequences we should use to build set of possible left sub-trees and right subtrees.
    //    we can add to both left and right sub-trees at least null value to avoid empty lists (to get into double loop)
    //    so, left sub-trees and right sub-trees are not empty - we should generate a composition of all possible variants.
    List<TreeNode> generateTrees(int n) {
        if (n == 0) return Collections.emptyList();
        return genTrees(1, n);
    }

    private List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> list = new LinkedList<>();

        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = genTrees(start, i - 1);
            List<TreeNode> rights = genTrees(i + 1, end);

            // here both lefts and rights are non empty, since we add null at least
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }

        return list;
    }
}
