class Solution:
    def removeVowels(self, s: str) -> str:
        if not s:
            return ""
        
        vowels = set("aeiou")
        return "".join([c for c in s if c not in vowels])