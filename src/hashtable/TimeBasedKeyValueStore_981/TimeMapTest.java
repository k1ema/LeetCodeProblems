package hashtable.TimeBasedKeyValueStore_981;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeMapTest {
    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new TimeMap_BS()),
                Arguments.of(new TimeMap_TreeMap())
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void test1(TimeMap tm) {
        tm.set("foo", "bar", 1);
        assertEquals("bar", tm.get("foo", 3));
        tm.set("foo", "bar2", 4);
        assertEquals("bar2", tm.get("foo", 4));
        assertEquals("bar2", tm.get("foo", 5));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void test2(TimeMap tm) {
        tm.set("love", "high", 10);
        tm.set("love", "low", 20);
        assertEquals("", tm.get("love", 5));
        assertEquals("high", tm.get("love", 10));
        assertEquals("high", tm.get("love", 15));
        assertEquals("low", tm.get("love", 20));
        assertEquals("low", tm.get("love", 25));
    }
}
