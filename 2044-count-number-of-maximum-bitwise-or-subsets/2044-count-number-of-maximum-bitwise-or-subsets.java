class Solution {
    public int countMaxOrSubsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxOr = 0;
        for (int num : nums) {
            maxOr |= num;
        }

        return dfs(nums, 0, 0, maxOr);
    }

    private int dfs(int[] nums, int index, int currentOr, int maxOr) {
        if (index == nums.length) {
            return currentOr == maxOr ? 1 : 0;
        }

        int include = dfs(nums, index + 1, currentOr | nums[index], maxOr);
        int exclude = dfs(nums, index + 1, currentOr, maxOr);

        return include + exclude;
    }
}