package string.ValidateIPAddress_468;

import java.net.Inet6Address;
import java.net.InetAddress;

/**
 * 468. Validate IP Address
 * https://leetcode.com/problems/validate-ip-address/
 *
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
 *
 * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal
 * numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
 *
 * Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
 *
 * IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits.
 * The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334
 * is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case
 * characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6
 * address(Omit leading zeros and using upper cases).
 *
 * However, we don't replace a consecutive group of zero value with a single empty group using two consecutive
 * colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
 *
 * Besides, extra leading zeros in the IPv6 is also invalid. For example, the address
 * 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
 *
 * Note: You may assume there is no extra space or special characters in the input string.
 *
 * Example 1:
 * Input: "172.16.254.1"
 * Output: "IPv4"
 * Explanation: This is a valid IPv4 address, return "IPv4".
 *
 * Example 2:
 * Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * Output: "IPv6"
 * Explanation: This is a valid IPv6 address, return "IPv6".
 *
 * Example 3:
 * Input: "256.256.256.256"
 * Output: "Neither"
 * Explanation: This is neither a IPv4 address nor a IPv6 address.
 */
public class Solution {
    public String validIPAddress(String IP) {
        return ipv4(IP) ? "IPv4" : ipv6(IP) ? "IPv6" : "Neither";
    }

    private boolean ipv4(String ip) {
        if (ip == null || ip.isEmpty()) return false;
        String[] parts = ip.split("\\.", -1);
        if (parts.length != 4) return false;
        for (String part : parts) {
            if (part.isEmpty()) return false;
            try {
                Integer num = Integer.parseInt(part);
                if (num == 0 && part.length() > 1 || num > 0 && part.charAt(0) == '0' || num > 255) return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    private boolean ipv6(String ip) {
        if (ip == null || ip.isEmpty()) return false;
        String[] parts = ip.split("\\:", -1);
        if (parts.length != 8) return false;
        for (String part : parts) {
            if (part.isEmpty() || part.length() > 4) return false;
            part = part.toLowerCase();
            for (int i = 0; i < part.length(); i++) {
                char c = part.charAt(i);
                if (Character.isAlphabetic(c) && c > 'f') return false;
            }
        }
        return true;
    }

    public String validIPAddress1(String IP) {
        if (IP == null || IP.isEmpty()) return "Neither";
        IP = IP.toLowerCase();
        String s0_255 = "[0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5]";
        String ipv4 = String.format("(%s).(%s).(%s).(%s)", s0_255, s0_255, s0_255, s0_255);
        String sHex = "0|([0-9]|[a-f]){1,4}";
        String ipv6 = String.format("(%s):(%s):(%s):(%s):(%s):(%s):(%s):(%s)", sHex, sHex, sHex, sHex, sHex, sHex, sHex, sHex);
        return IP.matches(ipv4) ? "IPv4" : (IP.matches(ipv6) ? "IPv6" : "Neither");
    }

    public String validIPAddress2(String IP) {
        try {
            return (InetAddress.getByName(IP) instanceof Inet6Address) ? "IPv6": "IPv4";
        } catch(Exception e) {}
        return "Neither";
    }
}
