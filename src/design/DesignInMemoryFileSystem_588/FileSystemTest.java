package design.DesignInMemoryFileSystem_588;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FileSystemTest {
    @Parameterized.Parameters(name = "fs: {0}")
    public static Object[] data() {
        return new Object[] {new FileSystem(), new FileSystem2()};
    }

    @Parameterized.Parameter
    public IFileSystem fs;

    @Test
    public void test() {
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
