package design.IteratorForCombination_1286;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1286. Iterator for Combination
 * https://leetcode.com/problems/iterator-for-combination/
 *
 * Design an Iterator class, which has:
 *
 * A constructor that takes a string characters of sorted distinct lowercase English letters and a number
 * combinationLength as arguments.
 * A function next() that returns the next combination of length combinationLength in lexicographical order.
 * A function hasNext() that returns True if and only if there exists a next combination.
 *
 * Example:
 * CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.
 * iterator.next(); // returns "ab"
 * iterator.hasNext(); // returns true
 * iterator.next(); // returns "ac"
 * iterator.hasNext(); // returns true
 * iterator.next(); // returns "bc"
 * iterator.hasNext(); // returns false
 *
 * Constraints:
 * 1 <= combinationLength <= characters.length <= 15
 * There will be at most 10^4 function calls per test.
 * It's guaranteed that all calls of the function next are valid.
 */
public class CombinationIterator {
    private final int LIMIT = 10000;
    private List<String> combinations = new ArrayList<>();
    private Iterator<String> it;

    // tc O(C(n,k) | limit 10^4), where n - combinationLength
    public CombinationIterator(String characters, int combinationLength) {
        bt(characters.toCharArray(), 0, combinationLength, new StringBuilder());
        it = combinations.iterator();
    }

    private void bt(char[] str, int i, int len, StringBuilder sb) {
        if (combinations.size() > LIMIT) return;
        if (sb.length() == len) {
            combinations.add(sb.toString());
            return;
        }
        for (int j = i; j < str.length; j++) {
            sb.append(str[j]);
            bt(str, j + 1, len, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // tc O(1)
    public String next() {
        return it.next();
    }

    // tc O(1)
    public boolean hasNext() {
        return it.hasNext();
    }
}
