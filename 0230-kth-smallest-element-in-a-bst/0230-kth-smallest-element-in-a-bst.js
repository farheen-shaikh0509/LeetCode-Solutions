var kthSmallest = function(root, k) {
    let count = 0;
    let result = 0;

    function inorder(node) {
        if (node === null) {
            return;
        }

        // Visit left subtree
        inorder(node.left);

        // Visit current node
        count++;

        if (count === k) {
            result = node.val;
            return;
        }

        // Visit right subtree
        inorder(node.right);
    }

    inorder(root);

    return result;
};