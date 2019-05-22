package math.PowerOfThree_326;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPowerOfThree(9)); // true;
        System.out.println(s.isPowerOfThree(243)); // true;
        System.out.println(s.isPowerOfThree(1162261467)); // true;
        System.out.println(s.isPowerOfThree(177146)); // false;
        System.out.println(s.isPowerOfThree(45)); // false;
        System.out.println(s.isPowerOfThree(-27)); // false;
        System.out.println(s.isPowerOfThree(0)); // false;
    }
}
