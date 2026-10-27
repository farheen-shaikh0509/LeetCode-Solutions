/**
 * @param {number[]} nums
 * @return {number}
 */
var maxAbsoluteSum = function(nums) {
    let prefixSum = 0;
    let minPrefix = 0;
    let maxPrefix = 0;
    let ans = 0;
    
    for (let num of nums) {
        prefixSum += num;
        ans = Math.max(ans, Math.abs(prefixSum - minPrefix), Math.abs(prefixSum - maxPrefix));
        minPrefix = Math.min(minPrefix, prefixSum);
        maxPrefix = Math.max(maxPrefix, prefixSum);
    }
    
    return ans;
};