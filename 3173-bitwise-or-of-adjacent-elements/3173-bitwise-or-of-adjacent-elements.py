class Solution:
    def orArray(self, nums: list[int]) -> list[int]:
        if not nums or len(nums) < 2:
            return []
        
        return [nums[i] | nums[i + 1] for i in range(len(nums) - 1)]