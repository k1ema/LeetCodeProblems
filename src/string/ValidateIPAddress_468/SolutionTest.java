package string.ValidateIPAddress_468;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("IPv4", s.validIPAddress("172.16.254.1"));
        assertEquals("IPv4", s.validIPAddress("0.0.0.0"));
        assertEquals("IPv4", s.validIPAddress("255.255.255.255"));
        assertEquals("Neither", s.validIPAddress("256.256.256.256"));
        assertEquals("Neither", s.validIPAddress("01.01.01.01"));
        assertEquals("IPv6", s.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        assertEquals("IPv6", s.validIPAddress("2001:0db8:85a3:0000:0:8A2E:0370:7334"));
        assertEquals("IPv6", s.validIPAddress("2001:0db8:85a3:033:0:8A2E:0370:7334"));
        assertEquals("IPv6", s.validIPAddress("2001:0db8:85a3:000:0:8A2E:0370:7334"));
        assertEquals("Neither", s.validIPAddress("2001:0db8:85a3::0:8A2E:0370:7334"));
    }
}