class Solution:
    def lateFee(self, daysLate: List[int]) -> int:
        total_fee = 0
        for x in daysLate:
            if x == 1:
                total_fee += x
            elif x >= 6:
                total_fee += 3 * x
            else:
                total_fee += 2 * x
        return total_fee