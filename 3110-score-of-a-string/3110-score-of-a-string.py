class Solution:
    def scoreOfString(self, s: str) -> int:
        if not s or len(s) < 2:
            return 0
        
        return sum(abs(ord(s[i]) - ord(s[i + 1])) for i in range(len(s) - 1))