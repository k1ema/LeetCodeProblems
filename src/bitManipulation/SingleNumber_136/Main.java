package bitManipulation.SingleNumber_136;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.singleNumber1(new int[] {2, 2, 1});
        System.out.println(i);
        i = s.singleNumber1(new int[] {4, 2, 1, 2, 1});
        System.out.println(i);
    }
}
