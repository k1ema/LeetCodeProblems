package hashtable.IntersectionOfTwoArrays_349;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] inter = s.intersection2(new int[] {}, new int[] {});
        System.out.println(Arrays.toString(inter));

        inter = s.intersection2(new int[] {1, 2, 2, 1}, new int[] {2, 2});
        System.out.println(Arrays.toString(inter));

        inter = s.intersection2(new int[] {4, 9, 5, 1}, new int[] {9, 4, 9, 8, 4});
        System.out.println(Arrays.toString(inter));
    }
}
