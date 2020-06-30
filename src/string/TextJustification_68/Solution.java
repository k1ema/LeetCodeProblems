package string.TextJustification_68;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. Text Justification
 * https://leetcode.com/problems/text-justification/
 *
 * Given an array of words and a width maxWidth, format the text such that each line has exactly
 * maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each
 * line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces
 * on a line do not divide evenly between words, the empty slots on the left will be assigned more
 * spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Note:
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 * Example 1:
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 *
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *
 * Example 2:
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 *
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 *              because the last line must be left-justified instead of fully-justified.
 *              Note that the second line is also left-justified becase it contains only one word.
 *
 * Example 3:
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 *
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 */
public class Solution {
    // https://leetcode.com/problems/text-justification/discuss/24891/Concise-python-solution-10-lines.
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<StringBuilder> current = new ArrayList<>();
        int numOfLetters = 0;

        for (String word : words) {
            StringBuilder w = new StringBuilder(word);

            if (numOfLetters + w.length() + current.size() > maxWidth) {
                for (int i = 0; i < (maxWidth - numOfLetters); i++) {
                    if (current.size() == 1) {
                        current.get(0).append(" ");
                    } else {
                        current.get(i % (current.size() - 1)).append(" ");
                    }
                }

                result.add(String.join("", current));

                current = new ArrayList<>();
                numOfLetters = 0;
            }

            current.add(w);
            numOfLetters += w.length();
        }

        result.add(String.format("%-" + maxWidth + "s", String.join(" ", current)));

        return result;
    }
}
