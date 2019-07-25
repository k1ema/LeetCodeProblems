package string.BasicCalculator_224;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.calculate("1+1"));
        assertEquals(2, s.calculate(" 1 + 1 "));
        assertEquals(-2, s.calculate(" - 1 - 1 "));
        assertEquals(3, s.calculate(" 2-1 + 2 "));
        assertEquals(-2, s.calculate(" - ( 1 + 1  ) "));
        assertEquals(1, s.calculate(" - ( 1 - 2  ) "));
        assertEquals(24, s.calculate("(2+(4+5+2)-3)+(6+8)"));
        assertEquals(3, s.calculate("   (  3 ) "));
        assertEquals(3, s.calculate(" ((((3)))) "));
        assertEquals(-5, s.calculate("(1+(4+5+2)-3)-(6+8)"));
        assertEquals(2147483647, s.calculate("2147483647"));
        assertEquals(-1, s.calculate("(5-(1+(5)))"));
        assertEquals(11, s.calculate("(5-(1-(5) - 3)-2)+1"));
        assertEquals(9, s.calculate("(5-(1-(5-2) - 3)-2)+1"));
        assertEquals(1, s.calculate("(((5)+1)-5)"));
        assertEquals(-1, s.calculate("(1)+(2)-(4)"));
        assertEquals(-1, s.calculate("((1)+(2)-(4))"));
        assertEquals(-1, s.calculate(" ( (1 ))+ ((   2   )) - ( ( 4 ) )"));
    }
}
