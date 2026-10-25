public class TreeNode{
    int val;
    TreeNode right, left;

TreeNode(){}
TreeNode(int val){
    this.val=val;
}
TreeNode(int val, TreeNode right, TreeNode left){
    this.val=val;
    this.right=right;
    this.left=left;
}

public List<Integer> InOrderTraversal(TreeNode root){
List<Integer> result = new ArrayList<>();
inorderHelper(root, result);
return result;
}

private void inorderHelper(TreeNode node, List<Integer> result){
if(node == null) return;
inorderHelper(node.left, result);
result.add(node.val);
inorderHelper(node.right, result);
}

}
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
while(curr != null || !stack.isEmpty()){
while(curr != null){
stack.push(curr);
curr = curr.left;
}
curr = stack.pop();
result.add(curr.val);
curr = curr.right;

}
return result;


    }
}