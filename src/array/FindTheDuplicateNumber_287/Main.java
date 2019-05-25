package array.FindTheDuplicateNumber_287;

/**
 * @author klema
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findDuplicate(new int[] {3, 1, 3, 4, 2}));
        System.out.println(s.findDuplicate(new int[] {3, 2, 1, 4, 7, 6, 5, 4, 8}));
        System.out.println(s.findDuplicate(new int[] {2, 5, 9, 6, 9, 3, 8, 9, 7, 1}));
    }
}
