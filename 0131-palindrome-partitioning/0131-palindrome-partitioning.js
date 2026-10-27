/**
 * @param {string} s
 * @return {string[][]}
 */
var partition = function(s) {
    let res = [];
    
    function isPalindrome(str, low, high) {
        while (low < high) {
            if (str[low++] !== str[high--]) {
                return false;
            }
        }
        return true;
    }
    
    function dfs(start, path) {
        if (start === s.length) {
            res.push([...path]);
            return;
        }
        
        for (let end = start; end < s.length; end++) {
            if (isPalindrome(s, start, end)) {
                path.push(s.substring(start, end + 1));
                dfs(end + 1, path);
                path.pop();
            }
        }
    }
    
    dfs(0, []);
    return res;
};