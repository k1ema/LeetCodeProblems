package hashtable.AnalyzeUserWebsiteVisitPattern_1152;

import java.util.*;

/**
 * 1152. Analyze User Website Visit Pattern
 * https://leetcode.com/problems/analyze-user-website-visit-pattern/
 *
 * We are given some website visits: the user with name username[i] visited
 * the website website[i] at time timestamp[i].
 *
 * A 3-sequence is a list of websites of length 3 sorted in ascending order
 * by the time of their visits.  (The websites in a 3-sequence are not
 * necessarily distinct.)
 *
 * Find the 3-sequence visited by the largest number of users. If there is
 * more than one solution, return the lexicographically smallest such 3-sequence.
 *
 * Example 1:
 * Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"],
 * timestamp = [1,2,3,4,5,6,7,8,9,10],
 * website = ["home","about","career","home","cart","maps","home","home","about","career"]
 * Output: ["home","about","career"]
 *
 * Explanation:
 * The tuples in this example are:
 * ["joe", 1, "home"]
 * ["joe", 2, "about"]
 * ["joe", 3, "career"]
 * ["james", 4, "home"]
 * ["james", 5, "cart"]
 * ["james", 6, "maps"]
 * ["james", 7, "home"]
 * ["mary", 8, "home"]
 * ["mary", 9, "about"]
 * ["mary", 10, "career"]
 * The 3-sequence ("home", "about", "career") was visited at least once by 2 users.
 * The 3-sequence ("home", "cart", "maps") was visited at least once by 1 user.
 * The 3-sequence ("home", "cart", "home") was visited at least once by 1 user.
 * The 3-sequence ("home", "maps", "home") was visited at least once by 1 user.
 * The 3-sequence ("cart", "maps", "home") was visited at least once by 1 user.
 *
 * Note:
 * 3 <= N = username.length = timestamp.length = website.length <= 50
 * 1 <= username[i].length <= 10
 * 0 <= timestamp[i] <= 10^9
 * 1 <= website[i].length <= 10
 * Both username[i] and website[i] contain only lowercase characters.
 * It is guaranteed that there is at least one user who visited at least 3 websites.
 * No user visits two websites at the same time.
 */
public class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<List<String>> sessions = new ArrayList<>();
        for (int i = 0; i < username.length; i++) {
            sessions.add(new ArrayList<>());
            sessions.get(i).add(username[i]);
            sessions.get(i).add("" + timestamp[i]);
            sessions.get(i).add(website[i]);
        }
        sessions.sort(Comparator.comparingInt(a -> Integer.parseInt(a.get(1))));

        Map<String, List<String>> visited = new HashMap<>(); // {username, list<website>}
        for (List<String> s : sessions) {
            visited.putIfAbsent(s.get(0), new ArrayList<>());
            visited.get(s.get(0)).add(s.get(2));
        }

        Map<String, Integer> sequence = new HashMap<>();//(sequence, count)
        int maxCount = 0;
        String maxseq = "";
        for (String name : visited.keySet()) {
            List<String> list = visited.get(name);
            if (list.size() < 3) continue;
            // build users' all 3-sequences, use set in case duplicated 3-sequences
            Set<String> subseqences = subseqence(list);
            for (String seq : subseqences) {
                sequence.put(seq, sequence.getOrDefault(seq, 0) + 1);
                if (sequence.get(seq) > maxCount) {
                    maxCount = sequence.get(seq);
                    maxseq = seq;
                } else if (sequence.get(seq) == maxCount && seq.compareTo(maxseq) < 0) {
                    maxseq = seq;
                }
            }
        }
        return Arrays.asList(maxseq.split(","));
    }

    private Set<String> subseqence(List<String> list) {
        int n = list.size();
        Set<String> res = new HashSet<>();
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    res.add(list.get(i) + "," + list.get(j) + "," + list.get(k));
                }
            }
        }
        return res;
    }
}
