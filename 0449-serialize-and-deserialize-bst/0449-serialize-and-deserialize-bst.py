# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Codec:

    def serialize(self, root):
        values = []

        def preorder(node):
            if not node:
                return
            values.append(str(node.val))
            preorder(node.left)
            preorder(node.right)

        preorder(root)
        return ",".join(values)

    def deserialize(self, data):
        if not data:
            return None

        values = list(map(int, data.split(",")))
        self.i = 0

        def build(lower, upper):
            if self.i >= len(values):
                return None

            val = values[self.i]

            if val < lower or val > upper:
                return None

            self.i += 1
            node = TreeNode(val)
            node.left = build(lower, val)
            node.right = build(val, upper)

            return node

        return build(float("-inf"), float("inf"))