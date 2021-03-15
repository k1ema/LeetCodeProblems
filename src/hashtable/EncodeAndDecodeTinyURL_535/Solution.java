package hashtable.EncodeAndDecodeTinyURL_535;

import java.util.HashMap;
import java.util.Map;

/**
 * 535. Encode and Decode TinyURL
 * https://leetcode.com/problems/encode-and-decode-tinyurl/
 *
 * Note: This is a companion problem to the System Design problem: Design TinyURL.
 * TinyURL is a URL shortening service where you enter a URL such as
 * https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.
 *
 * Design the encode and decode methods for the TinyURL service. There is no restriction on how your
 * encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny
 * URL and the tiny URL can be decoded to the original URL.
 */
public class Solution {
    private static final String abc = "abcdefghijklmnopqrstuvwxyz0123456789";
    private final Map<String, String> decoder = new HashMap<>();
    private int id = 1;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuilder sb = new StringBuilder();
        while (id > 0) {
            sb.append(abc.charAt(id % 36));
            id /= 26;
        }
        id++;
        String shortUrl = sb.toString();
        decoder.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if (!decoder.containsKey(shortUrl)) {
            throw new IllegalArgumentException("There is no such shortUrl encoded");
        }
        return decoder.get(shortUrl);
    }
}
