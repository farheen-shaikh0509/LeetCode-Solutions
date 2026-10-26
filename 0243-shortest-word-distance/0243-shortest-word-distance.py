class Solution:
    def shortestDistance(self, wordsDict: list[str], word1: str, word2: str) -> int:
        if not wordsDict:
            return -1
        
        min_dist = float('inf')
        i1, i2 = -1, -1
        
        for i, word in enumerate(wordsDict):
            if word == word1:
                i1 = i
            elif word == word2:
                i2 = i
            
            if i1 != -1 and i2 != -1:
                min_dist = min(min_dist, abs(i1 - i2))
                
        return min_dist if min_dist != float('inf') else -1