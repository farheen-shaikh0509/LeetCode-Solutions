import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        if (groupSizes == null || groupSizes.length == 0) {
            return result;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            map.putIfAbsent(size, new ArrayList<>());
            List<Integer> group = map.get(size);
            group.add(i);

            if (group.size() == size) {
                result.add(new ArrayList<>(group));
                group.clear();
            }
        }

        return result;
    }
}