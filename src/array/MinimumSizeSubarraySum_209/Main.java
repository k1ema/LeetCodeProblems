package array.MinimumSizeSubarraySum_209;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minSubArrayLen(3, new int[] {1, 1})); // 0
        System.out.println(s.minSubArrayLen(7, new int[] {21, 3, 1, 2, 4, 3})); // 1
        System.out.println(s.minSubArrayLen(4, new int[] {1, 4, 4})); // 1
        System.out.println(s.minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3})); // 2
        System.out.println(s.minSubArrayLen(11, new int[] {1, 2, 3, 4, 5})); // 3
    }
}
