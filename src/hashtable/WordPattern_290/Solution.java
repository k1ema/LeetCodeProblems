package hashtable.WordPattern_290;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 * https://leetcode.com/problems/word-pattern/
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in
 * pattern and a non-empty word in str.
 *
 * Example 1:
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 *
 * Example 2:
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 *
 * Example 3:
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 *
 * Example 4:
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 *
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase
 * letters that may be separated by a single space.
 */
public class Solution {
    /*
        init 2 has maps: mapChar(char->word) and mapWord(word->char)
        if for next existing char in mapChar word is not the same - return false
        if mapChar does not contain cur char and mapWord contains cur word - return false
            put entries to maps
        in the end return true
    */
    // tc O(N), where N represents the number of words in str or the number of characters in pattern.
    // sc O(M), where M represents the number of unique words in str. Even though we have two hash maps,
    // the character to word hash map has space complexity of O(1) since there can at most be 26 keys.
    // 2 ms, faster than 28.44%; 37.3 MB, less than 84.54%
    public boolean wordPattern1(String pattern, String str) {
        boolean b1 = pattern == null || pattern.isEmpty();
        boolean b2 = str == null || str.isEmpty();
        if (b1 && b2) return true;
        if (b1 || b2) return false;
        String[] ss = str.split("\\s");
        if (pattern.length() != ss.length) return false;
        Map<Character, String> mapChar = new HashMap<>();
        Map<String, Character> mapWord = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (mapChar.containsKey(c)) {
                if (!mapChar.get(c).equals(ss[i])) return false;
            } else {
                if (mapWord.containsKey(ss[i])) return false;
                mapChar.put(c, ss[i]);
                mapWord.put(ss[i], c);
            }
        }
        return true;
    }

    // Single Index Hash Map
    // tc O(N), where N represents the number of words in str or the number of characters in pattern.
    // sc O(M), where M represents the number of unique words in str. Even though we have two hash maps,
    public boolean wordPattern(String pattern, String str) {
        HashMap map_index = new HashMap();
        String[] words = str.split("\\s");

        if (words.length != pattern.length())
            return false;

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (!map_index.containsKey(c))
                map_index.put(c, i);

            if (!map_index.containsKey(w))
                map_index.put(w, i);

            if (!map_index.get(c).equals(map_index.get(w)))
                return false;
        }

        return true;
    }
}
