package design.DesignPhoneDirectory_379;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 379. Design a Phone Directory which supports the following operations:
 * https://leetcode.com/problems/design-phone-directory/
 *
 * get: Provide a number which is not assigned to anyone.
 * check: Check if a number is available or not.
 * release: Recycle or release a number.
 * Example:
 *
 * // Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
 * PhoneDirectory directory = new PhoneDirectory(3);
 *
 * // It can return any available phone number. Here we assume it returns 0.
 * directory.get();
 *
 * // Assume it returns 1.
 * directory.get();
 *
 * // The number 2 is available, so return true.
 * directory.check(2);
 *
 * // It returns 2, the only number that is left.
 * directory.get();
 *
 * // The number 2 is no longer available, so return false.
 * directory.check(2);
 *
 * // Release number 2 back to the pool.
 * directory.release(2);
 *
 * // Number 2 is available again, return true.
 * directory.check(2);
 */
// 6 ms, faster than 86.72%; 42.3 MB, less than 18.18%
public class PhoneDirectory {
    private int[] nums;
    private Queue<Integer> q;

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        nums = new int[maxNumbers];
        Arrays.fill(nums, -1);
        q = new LinkedList<>();
        for (int i = 0; i < maxNumbers; i++) {
            q.add(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (!q.isEmpty()) {
            int ind = q.poll();
            nums[ind] = ind;
            return nums[ind];
        } else {
            return -1;
        }
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return nums[number] == -1;
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (nums[number] != -1) {
            nums[number] = -1;
            q.add(number);
        }
    }
}
