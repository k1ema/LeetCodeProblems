package design.DesignInMemoryFileSystem_588;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileSystemTest {
    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new FileSystem()),
                Arguments.of(new FileSystem2())
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void test(IFileSystem fs) {
        List<String> ls = fs.ls("/");
        System.out.println(ls);

        fs.mkdir("/a/b/c");
        fs.mkdir("/e");

        fs.addContentToFile("/a/b/c/d", "hello");
        fs.addContentToFile("/a/b/c/dd", "hello jdsfsd");

        ls = fs.ls("/");
        System.out.println(ls);
        assertEquals(Arrays.asList("a", "e"), ls);

        String s = fs.readContentFromFile("/a/b/c/d");
        System.out.println(s);
        assertEquals("hello", s);

        fs.mkdir("/a/b/c/e");
        ls = fs.ls("/a/b/c");
        System.out.println(ls);
        assertEquals(Arrays.asList("d", "dd", "e"), ls);
    }
}
