package greedy.BoatsToSavePeople_881;

import java.util.Arrays;

/**
 * 881. Boats to Save People
 * https://leetcode.com/problems/boats-to-save-people/
 *
 * The i-th person has weight people[i], and each boat can carry a maximum weight of limit.
 *
 * Each boat carries at most 2 people at the same time, provided the sum of the weight of those people is at most limit.
 *
 * Return the minimum number of boats to carry every given person.  (It is guaranteed each person can be carried by a boat.)
 *
 * Example 1:
 * Input: people = [1,2], limit = 3
 * Output: 1
 * Explanation: 1 boat (1, 2)
 *
 * Example 2:
 * Input: people = [3,2,2,1], limit = 3
 * Output: 3
 * Explanation: 3 boats (1, 2), (2) and (3)
 *
 * Example 3:
 * Input: people = [3,5,3,4], limit = 5
 * Output: 4
 * Explanation: 4 boats (3), (3), (4), (5)
 *
 * Note:
 * 1 <= people.length <= 50000
 * 1 <= people[i] <= limit <= 30000
 */
public class Solution {
    // tc O(nlogn), sc O(n)
    public int numRescueBoats(int[] people, int limit) {
        int i = 0, j = people.length - 1, res = 0;
        Arrays.sort(people);
        while (i <= j) {
            res++;
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
        }
        return res;
    }

    // my solution, tc O(nlogn), sc O(n) - because of sorting algorithm
    public int numRescueBoats1(int[] people, int limit) {
        int boats = 0, curBoat = 0;
        Arrays.sort(people);
        int i = 0, j = people.length - 1, heads = 0;
        while (i <= j) {
            while (people[j] == limit) {
                boats++;
                j--;
            }
            while (i <= j && curBoat + people[j] <= limit && heads < 2) {
                curBoat += people[j--];
                heads++;
            }
            while (i <= j && curBoat + people[i] <= limit && heads < 2) {
                curBoat += people[i++];
                heads++;
            }
            if (curBoat > 0) {
                boats++;
                curBoat = 0;
                heads = 0;
            }
        }
        return boats;
    }
}
