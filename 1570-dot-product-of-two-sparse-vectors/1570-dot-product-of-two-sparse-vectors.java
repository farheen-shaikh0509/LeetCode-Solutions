import java.util.HashMap;
import java.util.Map;

class SparseVector {
    private Map<Integer, Integer> map;

    SparseVector(int[] nums) {
        map = new HashMap<>();
        if (nums == null) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }

    public int dotProduct(SparseVector vec) {
        if (vec == null || vec.map == null) {
            return 0;
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int idx = entry.getKey();
            if (vec.map.containsKey(idx)) {
                result += entry.getValue() * vec.map.get(idx);
            }
        }
        return result;
    }
}