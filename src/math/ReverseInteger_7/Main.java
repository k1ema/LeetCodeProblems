package math.ReverseInteger_7;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("321: " + s.reverse1(123));
        System.out.println("-321: " + s.reverse1(-123));
        System.out.println("21: " + s.reverse1(120));
        System.out.println("0: " + s.reverse1(0));
        System.out.println("0: " + s.reverse1(Integer.MAX_VALUE));
        System.out.println("0: " + s.reverse1(Integer.MIN_VALUE));
        System.out.println("0: " + s.reverse1(Integer.MAX_VALUE - 1));
        System.out.println("0: " + s.reverse1(Integer.MIN_VALUE + 1));
    }
}
