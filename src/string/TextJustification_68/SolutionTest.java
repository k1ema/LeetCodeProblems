package string.TextJustification_68;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList("This    is    an", "example  of text", "justification.  "),
                s.fullJustify(new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16));
        assertEquals(Arrays.asList("What   must   be", "acknowledgment  ", "shall be        "),
                s.fullJustify(new String[] {"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        assertEquals(Arrays.asList("Science  is  what we", "understand      well", "enough to explain to",
                "a  computer.  Art is", "everything  else  we", "do                  "),
                s.fullJustify(new String[] {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                        "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));
        assertEquals(Arrays.asList("ask   not   what", "your country can", "do  for  you ask", "what  you can do", "for your country"),
                s.fullJustify(new String[] {"ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask",
                        "what", "you", "can", "do", "for", "your", "country"}, 16));
    }
}