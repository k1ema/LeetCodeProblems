package array.MoveZeroes_283;

/**
 * Time complexity: O(n^(2+n))
 *
 * @author klema
 */
class SolutionSimple {
    void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && !allZeroesAfter(nums, i)) {
                shiftLeft(nums, i);
            }
        }
    }

    private void shiftLeft(int[] nums, int nullInd) {
        if (nullInd + 1 < nums.length && nums[nullInd + 1] == 0) {
            shiftLeft(nums, nullInd + 1);
        }
        for (int i = nullInd; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[nums.length - 1] = 0;
    }

    private boolean allZeroesAfter(int[] nums, int ind) {
        for (int i = ind + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
