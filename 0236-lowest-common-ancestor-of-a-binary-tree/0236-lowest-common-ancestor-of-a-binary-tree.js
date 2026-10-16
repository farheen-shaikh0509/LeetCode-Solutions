var lowestCommonAncestor = function(root, p, q) {
    // Base case: root is null, p, or q
    if (root === null || root === p || root === q) {
        return root;
    }

    // Search the left and right subtrees
    const left = lowestCommonAncestor(root.left, p, q);
    const right = lowestCommonAncestor(root.right, p, q);

    // If both sides return a node, root is the LCA
    if (left !== null && right !== null) {
        return root;
    }

    // Otherwise, return whichever side found p or q
    return left !== null ? left : right;
};