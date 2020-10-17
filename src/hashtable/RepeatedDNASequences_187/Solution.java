package hashtable.RepeatedDNASequences_187;

import java.util.*;

/**
 * 187. Repeated DNA Sequences
 * https://leetcode.com/problems/repeated-dna-sequences/
 *
 * All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G',
 * and 'T', for example: "ACGAATTCCG". When studying DNA, it is sometimes useful
 * to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 *
 * Example 1:
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC","CCCCCAAAAA"]
 *
 * Example 2:
 * Input: s = "AAAAAAAAAAAAA"
 * Output: ["AAAAAAAAAA"]
 *
 * Constraints:
 * 0 <= s.length <= 105
 * s[i] is 'A', 'C', 'G', or 'T'.
 */
public class Solution {
    // Rabin-Karp, tc O(N), sc O(N)
    // 14 ms, faster than 94.78%; 45.5 MB, less than 5.80%
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() <= 10) return new ArrayList<>();

        int n = s.length(), L = 10;
        int a = 4, aL = (int) Math.pow(a, L);

        Set<String> res = new HashSet<>();
        Set<Integer> seen = new HashSet<>();

        Map<Character, Integer> toInt = new HashMap<>() {{put('A', 0); put('C', 1); put('G', 2); put('T', 3);}};
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = toInt.get(s.charAt(i));
        }

        int h = 0;
        for (int start = 0; start < n - L + 1; start++) {
            if (start == 0) {
                for (int i = 0; i < L; i++) {
                    h = h * a + nums[i];
                }
            } else {
                h = h * a + nums[start + L - 1] - nums[start - 1] * aL;
            }
            if (seen.contains(h)) {
                res.add(s.substring(start, start + L));
            } else {
                seen.add(h);
            }
        }

        return new ArrayList<>(res);
    }

    // tc O((N - L) * L), sc O(N), where L = 10
    public List<String> findRepeatedDnaSequences1(String s) {
        Set<String> res = new HashSet<>(), seen = new HashSet<>();
        for (int i = 10; i <= s.length(); i++) {
            String substr = s.substring(i - 10, i);
            if (!seen.add(substr)) {
                res.add(substr);
            }
        }
        return new ArrayList<>(res);
    }
}
