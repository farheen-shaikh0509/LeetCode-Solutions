class Solution:
    def buildTree(self, inorder, postorder):
        inorder_index = {value: i for i, value in enumerate(inorder)}
        self.post_idx = len(postorder) - 1

        def build(left, right):
            if left > right:
                return None

            root_val = postorder[self.post_idx]
            self.post_idx -= 1

            root = TreeNode(root_val)
            mid = inorder_index[root_val]

            root.right = build(mid + 1, right)
            root.left = build(left, mid - 1)

            return root

        return build(0, len(inorder) - 1)