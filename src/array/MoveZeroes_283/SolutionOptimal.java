package array.MoveZeroes_283;

/**
 * Time complexity: O(n)
 *
 * @author klema
 */
public class SolutionOptimal {
    void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
                j++;
            }
        }
    }
}
