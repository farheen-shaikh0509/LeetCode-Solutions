class Solution:
    def lateFee(self, daysLate: list[int]) -> int:
        if not daysLate:
            return 0
        
        total_penalty = 0
        for days in daysLate:
            if days == 1:
                total_penalty += 1
            elif days <= 5:
                total_penalty += 2 * days
            else:
                total_penalty += 3 * days
                
        return total_penalty