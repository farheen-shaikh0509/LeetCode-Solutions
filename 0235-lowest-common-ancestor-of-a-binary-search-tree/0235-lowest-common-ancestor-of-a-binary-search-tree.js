var lowestCommonAncestor = function(root, p, q) {

    // Both nodes are in the left subtree

    if (p.val < root.val && q.val < root.val) {

        return lowestCommonAncestor(root.left, p, q);

    }

    // Both nodes are in the right subtree

    if (p.val > root.val && q.val > root.val) {

        return lowestCommonAncestor(root.right, p, q);

    }

    // Nodes split across subtrees, or root is p or q

    return root;

};