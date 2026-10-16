import heapq

class Solution:
    def minMeetingRooms(self, intervals):
        if not intervals:
            return 0

        # Sort meetings by start time
        intervals.sort(key=lambda x: x[0])

        # Min-heap stores meeting end times
        rooms = []

        for start, end in intervals:
            # Reuse a room if its meeting has ended
            if rooms and rooms[0] <= start:
                heapq.heappop(rooms)

            # Allocate a room for this meeting
            heapq.heappush(rooms, end)

        # Number of rooms needed
        return len(rooms)