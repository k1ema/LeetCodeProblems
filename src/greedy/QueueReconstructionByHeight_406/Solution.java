package greedy.QueueReconstructionByHeight_406;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 406. Queue Reconstruction by Height
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 *
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of
 * integers (h, k), where h is the height of the person and k is the number of people in front of this
 * person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 *
 * Note:
 * The number of people is less than 1,100.
 *
 * Example
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class Solution {
    /*
        1. sort input array: by height desc, among equal height -> by k asc
        2. create res list of array: List<int[]>
        3. iterate through input and put to res: res.add(p[1], p)
    */
    // tc O(n^2), sc O(n)
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            // if the heights are equal, compare k-values
            return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
        });

        List<int[]> output = new LinkedList<>();
        for(int[] p : people){
            output.add(p[1], p);
        }

        int n = people.length;
        return output.toArray(new int[n][2]);
    }
}
