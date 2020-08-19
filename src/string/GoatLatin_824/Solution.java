package string.GoatLatin_824;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 824. Goat Latin
 * https://leetcode.com/problems/goat-latin/
 *
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase
 * and uppercase letters only.
 *
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 *
 * The rules of Goat Latin are as follows:
 *
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 *
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 *
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * Return the final sentence representing the conversion from S to Goat Latin.
 *
 * Example 1:
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 *
 * Example 2:
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 *
 * Notes:
 * S contains only uppercase, lowercase and spaces. Exactly one space between each word.
 * 1 <= S.length <= 150.
 */
public class Solution {
    // tc O(n + k^2) = O(n^2) in worst case (when length of each word is 1 and char is consolant), sc O(n + k^2)
    // 2 ms, faster than 88.79%; 38.3 MB, less than 71.58%
    private static final HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String toGoatLatin(String S) {
        String[] ss = S.split("\\s");
        StringBuilder sb = new StringBuilder();
        StringBuilder a = new StringBuilder("a");
        for (int i = 0; i < ss.length; i++) {
            StringBuilder wordSb = new StringBuilder();
            if (vowels.contains(ss[i].charAt(0))) {
                wordSb.append(ss[i]);
            } else {
                if (ss[i].length() > 1) {
                    wordSb.append(ss[i].substring(1));
                }
                wordSb.append(ss[i].substring(0, 1));
            }
            wordSb.append("ma").append(a);
            sb.append(wordSb).append(" ");
            a.append("a");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
