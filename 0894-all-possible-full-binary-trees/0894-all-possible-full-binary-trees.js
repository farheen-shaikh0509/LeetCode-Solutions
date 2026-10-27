var allPossibleFBT = function(n, memo = new Map()) {
    if (n % 2 === 0) return [];
    if (n === 1) return [new TreeNode(0)];
    if (memo.has(n)) return memo.get(n);
    
    let res = [];
    for (let i = 1; i < n; i += 2) {
        let leftTrees = allPossibleFBT(i, memo);
        let rightTrees = allPossibleFBT(n - 1 - i, memo);
        
        for (let l of leftTrees) {
            for (let r of rightTrees) {
                let root = new TreeNode(0, l, r);
                res.push(root);
            }
        }
    }
    memo.set(n, res);
    return res;
};