package string.CompareVersionNumbers_165;

/**
 * 165. Compare Version Numbers
 * https://leetcode.com/problems/compare-version-numbers/
 *
 * ompare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and
 * the . character.
 *
 * The . character does not represent a decimal point and is used to separate number sequences.
 *
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth
 * second-level revision of the second first-level revision.
 *
 * You may assume the default revision number for each level of a version number to be 0. For
 * example, version number 3.4 has a revision number of 3 and 4 for its first and second level
 * revision number. Its third and fourth level revision number are both 0.
 *
 * Example 1:
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 *
 * Example 2:
 * Input: version1 = "1.0.1", version2 = "1"
 * Output: 1
 *
 * Example 3:
 * Input: version1 = "7.5.2.4", version2 = "7.5.3"
 * Output: -1
 *
 * Example 4:
 * Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”
 *
 * Example 5:
 * Input: version1 = "1.0", version2 = "1.0.0"
 * Output: 0
 * Explanation: The first version number does not have a third level revision number, which means
 * its third level revision number is default to "0"
 *
 * Note:
 * Version strings are composed of numeric strings separated by dots . and this numeric strings
 * may have leading zeroes.
 * Version strings do not start or end with dots, and they will not be two consecutive dots.
 */
public class Solution {
    // tc O(n + m + max(n,m)), sc O(n + m)
    // 1 ms, faster than 92.95%; 36.8 MB, less than 99.72%
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        for (int i = 0; i < Math.max(nums1.length, nums2.length); i++) {
            int v1 = i < nums1.length ? Integer.parseInt(nums1[i]) : 0;
            int v2 = i < nums2.length ? Integer.parseInt(nums2[i]) : 0;
            if (v1 != v2) return (int) Math.signum(v1 - v2);
        }
        return 0;
    }
    
    // my solution
    // tc O(n + m + max(n,m)), sc O(n + m)
    public int compareVersion1(String version1, String version2) {
        String[] sv1 = version1.split("\\.");
        String[] sv2 = version2.split("\\.");
        int n1 = sv1.length, n2 = sv2.length;
        for (int i = 0; i < Math.max(n1, n2); i++) {
            if (i < n1 && i < n2) {
                int v1 = Integer.parseInt(sv1[i]);
                int v2 = Integer.parseInt(sv2[i]);
                if (v1 != v2) {
                    return (int) Math.signum(v1 - v2);
                }
            } else {
                boolean swapped = false;
                if (i == n1) {
                    sv1 = sv2;
                    swapped = true;
                }
                while (i < sv1.length && Integer.parseInt(sv1[i]) == 0) {
                    i++;
                }
                return i == sv1.length ? 0 : (swapped ? -1 : 1);
            }
        }
        return 0;
    }
}
