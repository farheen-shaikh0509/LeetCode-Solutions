from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def closestValue(self, root: Optional[TreeNode], target: float) -> int:
        if not root:
            return 0
        
        closest = root.val
        current = root
        
        while current:
            if abs(current.val - target) < abs(closest - target):
                closest = current.val
            elif abs(current.val - target) == abs(closest - target):
                closest = min(closest, current.val)
                
            if target < current.val:
                current = current.left
            elif target > current.val:
                current = current.right
            else:
                break
                
        return closest