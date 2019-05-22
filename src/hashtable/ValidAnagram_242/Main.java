package hashtable.ValidAnagram_242;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        boolean b = s.isAnagram("", "");
        System.out.println(b);

        b = s.isAnagram1("anagram", "nagaram");
        System.out.println(b); // true

        b = s.isAnagram1("cat", "rat");
        System.out.println(b); // false

        b = s.isAnagram1("ccaa", "ccac");
        System.out.println(b); // false
    }
}
