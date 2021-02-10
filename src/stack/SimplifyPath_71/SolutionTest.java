package stack.SimplifyPath_71;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("/home", s.simplifyPath("/home/"));
        assertEquals("/", s.simplifyPath("/../"));
        assertEquals("/home/foo", s.simplifyPath("/home//foo/"));
        assertEquals("/c", s.simplifyPath("/a/./b/../../c/"));
        assertEquals("/c", s.simplifyPath("/a/../../b/../c//.//"));
        assertEquals("/a/b/c", s.simplifyPath("/a//b////c/d//././/.."));
        assertEquals("/...", s.simplifyPath("/..."));
        assertEquals("/home/foo/as/s", s.simplifyPath("/home//foo/as/afdsf/../s"));
    }
}