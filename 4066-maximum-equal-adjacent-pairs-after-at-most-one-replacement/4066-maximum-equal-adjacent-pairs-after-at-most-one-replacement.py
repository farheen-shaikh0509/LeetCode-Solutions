from collections import defaultdict

class Solution:
    @staticmethod
    def maxEqualAdjacentPairs(nums: list[int]) -> int:
        ans = 0
        pair_counts = defaultdict(int)
        max_new_pairs = 0
        
        for i in range(len(nums) - 1):
            x, y = nums[i], nums[i + 1]
            if x == y:
                ans += 1
            else:
                # Normalize order to treat (x, y) and (y, x) as the same pair
                p = (x, y) if x < y else (y, x)
                pair_counts[p] += 1
                if pair_counts[p] > max_new_pairs:
                    max_new_pairs = pair_counts[p]
                    
        return ans + max_new_pairs