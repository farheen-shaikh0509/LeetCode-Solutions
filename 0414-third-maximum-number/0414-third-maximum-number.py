class Solution:
    def thirdMax(self, nums: list[int]) -> int:
        if not nums:
            return 0
        
        first = second = third = float('-inf')
        
        for num in nums:
            if num > first:
                first, second, third = num, first, second
            elif first > num > second:
                second, third = num, second
            elif second > num > third:
                third = num
                
        return third if third != float('-inf') else first