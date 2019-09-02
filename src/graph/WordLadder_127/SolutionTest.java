package graph.WordLadder_127;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SolutionTest {
    @Parameterized.Parameters(name = "s: {0}")
    public static Object[] data() {
        return new Object[] {new Solution(), new BidirectionalSolution()};
    }

    @Parameterized.Parameter
    public ISolution s;

    @Test
    public void test() {
        assertEquals(5, s.ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        assertEquals(0, s.ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log")));
        assertEquals(5, s.ladderLength("qa", "sq",
                Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm",
                        "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow",
                        "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr",
                        "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh",
                        "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm",
                        "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt",
                        "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye")));
    }
}
