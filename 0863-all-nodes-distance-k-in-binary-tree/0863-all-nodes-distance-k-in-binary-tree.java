class Solution {
public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
Map<TreeNode, TreeNode> parent = new HashMap<>();

buildParentMap(root, null, parent);
Queue<TreeNode> queue = new LinkedList<>();
Set<TreeNode> visited = new HashSet<>();

queue.offer(target);
visited.add(target);

int distance = 0;

while(!queue.isEmpty()){
    int size = queue.size();
    if(distance == k){
        List<Integer> result = new ArrayList<>();
        
        for(TreeNode node : queue){
            result.add(node.val);
        }
        return result;
    }

for(int i = 0; i < size; i++){
    TreeNode current = queue.poll();

if(current.left != null && visited.add(current.left)){
    queue.offer(current.left);
}

if(current.right != null && visited.add(current.right)){
    queue.offer(current.right);
}
TreeNode p = parent.get(current);
 if (p != null && visited.add(p)) {
                queue.offer(p);
            }

}

distance++;
    }
    return new ArrayList<>();
}

private void buildParentMap(
    TreeNode node,
    TreeNode p,
    Map<TreeNode, TreeNode> parent){
        if(node == null){
            return;
        }
        parent.put(node, p);
        buildParentMap(node.left, node, parent);
        buildParentMap(node.right, node, parent);

    }
}