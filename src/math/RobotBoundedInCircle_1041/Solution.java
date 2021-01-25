package math.RobotBoundedInCircle_1041;

/**
 * 1041. Robot Bounded In Circle
 * https://leetcode.com/problems/robot-bounded-in-circle/
 *
 * On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot
 * can receive one of three instructions:
 *
 * "G": go straight 1 unit;
 * "L": turn 90 degrees to the left;
 * "R": turn 90 degress to the right.
 * The robot performs the instructions given in order, and repeats them forever.
 *
 * Return true if and only if there exists a circle in the plane such that the robot
 * never leaves the circle.
 *
 * Example 1:
 * Input: "GGLLGG"
 * Output: true
 *
 * Explanation:
 * The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
 * When repeating these instructions, the robot remains in the circle of radius 2
 * centered at the origin.
 *
 * Example 2:
 * Input: "GG"
 * Output: false
 *
 * Explanation:
 * The robot moves north indefinitely.
 *
 * Example 3:
 * Input: "GL"
 * Output: true
 *
 * Explanation:
 * The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 *
 * Note:
 * 1 <= instructions.length <= 100
 * instructions[i] is in {'G', 'L', 'R'}
 */
public class Solution {
    // tc O(n), sc O(1)
    // 0 ms, faster than 100.00%; 37.4 MB, less than 54.55%
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int curInd = 0;
        for (char instr : instructions.toCharArray()) {
            if (instr == 'L') {
                // 1 turn to the left = 3 turns to the right
                curInd = (curInd + 3) % 4;
            } else if (instr == 'R') {
                curInd = (curInd + 1) % 4;
            } else {
                x += dirs[curInd][0];
                y += dirs[curInd][1];
            }
        }
        return x == 0 && y == 0 || curInd != 0;
    }
}
