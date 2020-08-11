package sorting.H_Index_274;

import java.util.Arrays;

/**
 * 274. H-Index
 * https://leetcode.com/problems/h-index/
 *
 * Given an array of citations (each citation is a non-negative integer) of a researcher,
 * write a function to compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers
 * have at least h citations each, and the other N − h papers have no more than h citations each."
 *
 * Example:
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
 *              received 3, 0, 6, 1, 5 citations respectively.
 *              Since the researcher has 3 papers with at least 3 citations each and the remaining
 *              two with no more than 3 citations each, her h-index is 3.
 *
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 */
public class Solution {
    /*
            3 0 6 1 5
     papers 1 1   1   2
            0 1 2 3 4 5

            2 0 6 1 5
     papers 1 1 1     2
            0 1 2 3 4 5
     */
    // tc O(n), sc O(n)
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int[] papers = new int[n + 1];
        for (int c : citations) {
            papers[Integer.min(c, n)]++;
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += papers[i];
            if (count >= i) return i;
        }
        return 0;
    }

    // tc O(nlogn)
    public int hIndex2(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) return n - i;
        }
        return 0;
    }
}
