class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        last_occurrence = {c: i for i, c in enumerate(s)}
        stack = []
        seen = set()
        for i, char in enumerate(s):
            if char in seen:
                continue
            while stack and stack[-1] > char and last_occurrence[stack[-1]] > i:
                seen.remove(stack.pop()) 
            stack.append(char)
            seen.add(char)
            
        return "".join(stack)   