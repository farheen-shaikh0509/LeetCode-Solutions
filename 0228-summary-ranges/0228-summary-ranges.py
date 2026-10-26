class Solution:
    def summaryRanges(self, nums: list[int]) -> list[str]:
        res = []
        if not nums:
            return res
        
        start = nums[0]
        for i in range(len(nums)):
            if i == len(nums) - 1 or nums[i] + 1 != nums[i + 1]:
                if start == nums[i]:
                    res.append(str(start))
                else:
                    res.append(f"{start}->{nums[i]}")
                if i + 1 < len(nums):
                    start = nums[i + 1]
        return res