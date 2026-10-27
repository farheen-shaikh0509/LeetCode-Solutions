class Solution:
    def longestSubarray(self, nums: list[int], k: int) -> int:
        def solve(arr: list[int]) -> int:
            d = {0: -1}
            s = res = 0
            for i, x in enumerate(arr):
                s = (s + x) % k
                if s < 0:
                    s += k
                if s in d:
                    res = max(res, i - d[s])
                else:
                    d[s] = i
            return res

        ans = solve(nums)
        for i, x in enumerate(nums):
            nums[i] = -x
            ans = max(ans, solve(nums))
            nums[i] = x
        return ans