class Solution:
    def readBinaryWatch(self, turnedOn: int) -> list[str]:
        if turnedOn < 0 or turnedOn > 10:
            return []
        
        result = []
        for h in range(12):
            for m in range(60):
                if (bin(h).count("1") + bin(m).count("1")) == turnedOn:
                    result.append(f"{h}:{m:02d}")
        return result