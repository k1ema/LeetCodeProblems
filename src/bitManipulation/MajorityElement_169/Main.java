package bitManipulation.MajorityElement_169;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.majorityElement(new int[] {3, 2, 3}));
        System.out.println(s.majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2}));
        System.out.println(s.majorityElement(new int[] {1, 1, 1, 2, 2, 4, 4, 1, 1}));
        System.out.println(s.majorityElement(new int[] {Integer.MAX_VALUE}));
        System.out.println(s.majorityElement(new int[] {Integer.MIN_VALUE}));
    }
}
