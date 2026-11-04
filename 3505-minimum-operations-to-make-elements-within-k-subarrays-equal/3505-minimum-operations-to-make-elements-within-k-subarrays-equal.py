from typing import List
from sortedcontainers import SortedList

class Solution:
    def minOperations(self, nums: List[int], x: int, k: int) -> int:
        n = len(nums)
        
        # Step 1: Precalculate window costs using sliding window & two SortedLists
        min_ops = [0] * n
        lower = SortedList()
        upper = SortedList()
        lower_sum = 0
        upper_sum = 0
        
        for i in range(n):
            val = nums[i]
            if not lower or val <= lower[-1]:
                lower.add(val)
                lower_sum += val
            else:
                upper.add(val)
                upper_sum += val
            
            if i >= x:
                out_val = nums[i - x]
                if out_val in lower:
                    lower.remove(out_val)
                    lower_sum -= out_val
                else:
                    upper.remove(out_val)
                    upper_sum -= out_val
            
            if len(lower) < len(upper):
                v = upper.pop(0)
                lower.add(v)
                upper_sum -= v
                lower_sum += v
            elif len(lower) - len(upper) > 1:
                v = lower.pop()
                upper.add(v)
                lower_sum -= v
                upper_sum += v
            
            if i >= x - 1:
                median = lower[-1]
                min_ops[i] = (median * len(lower) - lower_sum) + (upper_sum - median * len(upper))

        # Step 2: Bottom-Up DP with rolling/compressed state arrays to save memory
        INF = float('inf')
        
        # dp[rem_k][i] can be space-optimized, but using a flat list or table 
        # sized strictly for necessary states prevents excessive memory allocation.
        dp = [INF] * (n + 1)
        dp[0] = 0
        
        for r in range(1, k + 1):
            next_dp = [INF] * (n + 1)
            # We can iterate backwards or maintain running minimums to optimize transitions
            min_val = INF
            for i in range(n - 1, -1, -1):
                # If we pick a window starting at index i (ending at i + x - 1)
                if i + x <= n:
                    cost = min_ops[i + x - 1]
                    # We need the best from dp[r-1] starting at or after i + x
                    # To keep it memory and time efficient, track suffix minimums
                    pass
            # Alternatively, standard iterative table:
        
        # Let's use a 2D table sized precisely as (k + 1) x (n + 1)
        dp = [[INF] * (n + 1) for _ in range(k + 1)]
        for i in range(n + 1):
            dp[0][i] = 0
            
        for rem_k in range(1, k + 1):
            current_min = INF
            # Iterate backwards from n down to 0
            for i in range(n, -1, -1):
                # Option to skip index i
                if i + 1 <= n:
                    dp[rem_k][i] = dp[rem_k][i + 1]
                
                # Option to pick window starting at i
                if i + x <= n:
                    pick_val = min_ops[i + x - 1] + dp[rem_k - 1][i + x]
                    dp[rem_k][i] = min(dp[rem_k][i], pick_val)
                    
        return dp[k][0] if dp[k][0] != INF else -1