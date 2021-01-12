package design.ImplementSegmentTree;

public class Main {
    public static void main(String[] args) {
        SegmentTree st = new SegmentTree(new int[] {1, 3, 5, 7, 9, 11});
        System.out.println(st.getSum(1, 3));

        st.update(1, 10);
        System.out.println(st.getSum(1, 3));
    }
}
