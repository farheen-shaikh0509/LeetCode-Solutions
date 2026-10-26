from collections import defaultdict

class TwoSum:

    def __init__(self):
        self.counts = defaultdict(int)

    def add(self, number: int) -> None:
        self.counts[number] += 1

    def find(self, value: int) -> bool:
        for num in self.counts:
            complement = value - num
            if complement in self.counts:
                if complement != num or self.counts[num] > 1:
                    return True
        return False