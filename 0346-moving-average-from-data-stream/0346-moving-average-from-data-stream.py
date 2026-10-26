from collections import deque


class MovingAverage:
    def __init__(self, size: int):
        if size <= 0:
            raise ValueError("Size must be greater than 0")
        self.size = size
        self.queue = deque()
        self.window_sum = 0.0

    def next(self, val: int) -> float:
        if len(self.queue) >= self.size:
            self.window_sum -= self.queue.popleft()
        self.queue.append(val)
        self.window_sum += val
        return self.window_sum / len(self.queue)