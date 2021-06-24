package hashtable.TimeBasedKeyValueStore_981;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class TimeMap_TreeMap implements TimeMap {
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap_TreeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        return Optional.ofNullable(map.get(key).floorEntry(timestamp))
                .map(Map.Entry::getValue).orElse("");
    }
}
