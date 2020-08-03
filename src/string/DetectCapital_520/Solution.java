package string.DetectCapital_520;

/**
 * 520. Detect Capital
 * https://leetcode.com/problems/detect-capital/
 *
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 *
 * Example 1:
 * Input: "USA"
 * Output: True
 *
 * Example 2:
 * Input: "FlaG"
 * Output: False
 *
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
public class Solution {
    // tc O(n), sc O(1)
    public boolean detectCapitalUse(String word) {
        boolean allUpper = true, oneUpper = true, allLower = true;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            boolean isLower = isLower(c);
            if (isLower) {
                allUpper = false;
                if (i == 0) oneUpper = false;
            } else {
                allLower = false;
                if (i > 0) oneUpper = false;
            }
        }
        return allUpper || oneUpper || allLower;
    }

    private boolean isLower(char c) {
        return c >= 'a' && c <= 'z';
    }

    // see solutions
    public boolean detectCapitalUse1(String word) {
        return word.matches("[A-Z]*|.[a-z]*");
    }
}
