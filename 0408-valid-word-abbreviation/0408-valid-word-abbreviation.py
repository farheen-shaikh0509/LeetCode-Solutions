class Solution:
    def validWordAbbreviation(self, word: str, abbr: str) -> bool:
        if not word or not abbr:
            return word == abbr
        
        i, j = 0, 0
        len_word, len_abbr = len(word), len(abbr)
        
        while i < len_word and j < len_abbr:
            if abbr[j].isdigit():
                if abbr[j] == '0':
                    return False
                num = 0
                while j < len_abbr and abbr[j].isdigit():
                    num = num * 10 + int(abbr[j])
                    j += 1
                i += num
            else:
                if word[i] != abbr[j]:
                    return False
                i += 1
                j += 1
                
        return i == len_word and j == len_abbr