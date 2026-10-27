/**
 * @param {number} lo
 * @param {number} hi
 * @param {number} k
 * @return {number}
 */
var getKth = function(lo, hi, k) {
    const memo = new Map();
    
    function getPower(x) {
        if (x === 1) {
            return 0;
        }
        if (memo.has(x)) {
            return memo.get(x);
        }
        let res = x % 2 === 0 ? 1 + getPower(x / 2) : 1 + getPower(3 * x + 1);
        memo.set(x, res);
        return res;
    }
    
    const arr = [];
    for (let i = lo; i <= hi; i++) {
        arr.push([i, getPower(i)]);
    }
    
    arr.sort((a, b) => {
        if (a[1] !== b[1]) {
            return a[1] - b[1];
        }
        return a[0] - b[0];
    });
    
    return arr[k - 1][0];
};