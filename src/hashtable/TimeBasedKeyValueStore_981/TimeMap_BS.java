package hashtable.TimeBasedKeyValueStore_981;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap_BS implements TimeMap {
    private static class Node {
        private int timestamp;
        private String value;

        private Node(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private Map<String, List<Node>> map;

    /** Initialize your data structure here. */
    public TimeMap_BS() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Node(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Node> nodes = map.get(key);
        int l = -1, r = nodes.size();
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (nodes.get(m).timestamp <= timestamp) {
                l = m;
            } else {
                r = m;
            }
        }
        return l == -1 ? "" : nodes.get(l).value;
    }
}
