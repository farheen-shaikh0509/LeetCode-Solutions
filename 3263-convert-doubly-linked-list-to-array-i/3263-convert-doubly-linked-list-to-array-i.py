from typing import Optional


class Node:
    def __init__(self, val=0, prev=None, next=None):
        self.val = val
        self.prev = prev
        self.next = next


class Solution:
    def toArray(self, head: Optional[Node]) -> list[int]:
        if not head:
            return []
        
        result = []
        current = head
        while current:
            result.append(current.val)
            current = current.next
        return result