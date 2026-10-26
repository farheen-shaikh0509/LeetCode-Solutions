import java.util.ArrayList;
import java.util.List;

public class Solution {
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> sortedVals = new ArrayList<>();
        inorder(root, sortedVals);
        return build(sortedVals, 0, sortedVals.size() - 1);
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    private TreeNode build(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = build(list, start, mid - 1);
        node.right = build(list, mid + 1, end);
        return node;
    }
}