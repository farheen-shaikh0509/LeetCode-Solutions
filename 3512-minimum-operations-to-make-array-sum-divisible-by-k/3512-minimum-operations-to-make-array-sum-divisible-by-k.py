class Solution:
    def minOperations(self, nums: list[int], k: int) -> int:
        if not nums or k <= 0:
            return 0
        return sum(nums) % k