package backtracking.RestoreIPAddresses_93;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 93. Restore IP Addresses
 * https://leetcode.com/problems/restore-ip-addresses/
 *
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * A valid IP address consists of exactly four integers (each integer is between 0 and 255) separated by single points.
 *
 * Example:
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
public class Solution {
    // tc: there is not more than 27 combinations to check.
    // Space complexity : constant space to keep the solutions, not more than 19 valid IP addresses.
    // Runtime: 9 ms, Memory Usage: 40 MB
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) return new ArrayList<>();
        Set<String> res = new HashSet<>();
        bt(s, 1, 2, 3, res);
        return new ArrayList<>(res);
    }

    private void bt(String s, int i, int j, int k, Set<String> res) {
        if (i == j || j == k || k == s.length()) return;
        String s1 = s.substring(0, i);
        String s2 = s.substring(i, j);
        String s3 = s.substring(j, k);
        String s4 = s.substring(k);
        if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
            res.add(s1 + "." + s2 + "." + s3 + "." + s4);
        }
        int v1 = Integer.parseInt(s1);
        int v2 = Integer.parseInt(s2);
        int v3 = Integer.parseInt(s3);
        if (v1 < 26) bt(s, i + 1, j, k, res);
        if (v2 < 26) bt(s, i, j + 1, k, res);
        if (v3 < 26) bt(s, i, j, k + 1, res);
    }

    private boolean isValid(String s) {
        return Integer.parseInt(s) < 256 && (s.charAt(0) != '0' || s.length() == 1);
    }


    // 4 ms, faster than 66.27%; 39.6 MB, less than 66.27%
    public List<String> restoreIpAddresses1(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) return res;
        bt(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void bt(String s, int i, List<String> current, List<String> res) {
        if (current.size() == 4 && i == s.length()) {
            res.add(String.join(".", current));
            return;
        }
        for (int j = 1; j <= 3; j++) {
            if (i + j <= s.length()) {
                String section = s.substring(i, i + j);
                if (isSectionValid(section)) {
                    current.add(section);
                    bt(s, i + j, current, res);
                    current.remove(current.size() - 1);
                }
            }
        }
    }

    private boolean isSectionValid(String s) {
        if (s == null || s.isEmpty()) return false;
        return s.length() <= 3 && (!s.startsWith("0") || s.length() == 1) && Integer.parseInt(s) < 256;
    }
}
