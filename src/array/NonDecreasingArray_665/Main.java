package array.NonDecreasingArray_665;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        boolean b = s.checkPossibility1(new int[] {4, 2, 1}); // false
        System.out.println(b);

        b = s.checkPossibility1(new int[] {4, 2, 3}); // true
        System.out.println(b);

        b = s.checkPossibility1(new int[] {4}); // true
        System.out.println(b);

        b = s.checkPossibility1(new int[] {3, 4, 2, 3}); // false
        System.out.println(b);

        b = s.checkPossibility1(new int[] {3, 3, 2, 2}); // false
        System.out.println(b);
    }
}
