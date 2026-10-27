class Solution {
    private Set<Integer> targetValues;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        targetValues = new HashSet<>();
        for (TreeNode node : nodes) {
            targetValues.add(node.val);
        }
        return dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null || targetValues.contains(root.val)) {
            return root;
        }

        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}