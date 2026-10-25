/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    preorder(root, sb);
    return sb.toString();
    }
    private void preorder(TreeNode root, StringBuilder sb) {
    if (root == null) {
        sb.append("#,");
        return;
        }
    sb.append(root.val).append(",");
    preorder(root.left, sb);
    preorder(root.right, sb);
    }
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(
            Arrays.asList(data.split(","))
        );
        return buildTree(queue);
    }
    private TreeNode buildTree(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }
}