package hashtable.FirstUniqueNumber_1429;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUnique2 {
    private Map<Integer, Integer> map = new LinkedHashMap<>();

    // tc O(k), k - initial nums length
    public FirstUnique2(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
    }

    // tc O(n), n - map size
    public int showFirstUnique() {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return -1;
    }

    // tc O(1)
    public void add(int value) {
        map.put(value, map.getOrDefault(value, 0) + 1);
    }
}
