import java.util.*;

class Solution {
    public long countTheNumOfKFreeSubsets(int[] nums, int k) {
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int num : nums) {
            groups.computeIfAbsent(num % k, x -> new ArrayList<>()).add(num);
        }

        long totalSubsets = 1;
        for (List<Integer> list : groups.values()) {
            Collections.sort(list); 
            long take = 0; 
            long skip = 1; 
            for (int i = 0; i < list.size(); i++) {
                long prevTake = take;
                long prevSkip = skip;

                if (i > 0 && list.get(i) - list.get(i - 1) == k) {
                    // Cannot pick current element if previous was picked
                    take = prevSkip;
                    skip = prevTake + prevSkip;
                } else {
                    // No restriction with previous element; double total options
                    take = prevTake + prevSkip;
                    skip = prevTake + prevSkip;
                }
            }

            totalSubsets *= (take + skip);
        }

        return totalSubsets;
    }
}