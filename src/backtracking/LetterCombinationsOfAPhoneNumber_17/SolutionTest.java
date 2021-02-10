package backtracking.LetterCombinationsOfAPhoneNumber_17;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        List<String> combinations = s.letterCombinations("23");
        assertEquals(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), combinations);
        combinations = s.letterCombinations("234");
        assertEquals(Arrays.asList(
                "adg", "adh", "adi", "aeg", "aeh", "aei", "afg", "afh", "afi",
                "bdg", "bdh", "bdi", "beg", "beh", "bei", "bfg", "bfh", "bfi",
                "cdg", "cdh", "cdi", "ceg", "ceh", "cei",  "cfg", "cfh", "cfi"
        ), combinations);
        combinations = s.letterCombinations("5678");
        assertEquals(Arrays.asList(
                "jmpt","jmpu","jmpv","jmqt","jmqu","jmqv","jmrt","jmru","jmrv","jmst","jmsu","jmsv","jnpt","jnpu","jnpv","jnqt","jnqu","jnqv","jnrt","jnru","jnrv","jnst","jnsu","jnsv","jopt","jopu","jopv","joqt","joqu","joqv","jort","joru","jorv","jost","josu","josv","kmpt","kmpu","kmpv","kmqt","kmqu","kmqv","kmrt","kmru","kmrv","kmst","kmsu","kmsv","knpt","knpu","knpv","knqt","knqu","knqv","knrt","knru","knrv","knst","knsu","knsv","kopt","kopu","kopv","koqt","koqu","koqv","kort","koru","korv","kost","kosu","kosv","lmpt","lmpu","lmpv","lmqt","lmqu","lmqv","lmrt","lmru","lmrv","lmst","lmsu","lmsv","lnpt","lnpu","lnpv","lnqt","lnqu","lnqv","lnrt","lnru","lnrv","lnst","lnsu","lnsv","lopt","lopu","lopv","loqt","loqu","loqv","lort","loru","lorv","lost","losu","losv"
        ), combinations);
    }
}
