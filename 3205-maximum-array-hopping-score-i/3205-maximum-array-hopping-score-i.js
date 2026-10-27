/**
 * @param {number[]} nums
 * @return {number}
 */
var maxScore = function(nums) {
    let ans = 0;
    let mx = 0;
    for (let i = nums.length - 1; i > 0; --i) {
        mx = Math.max(mx, nums[i]);
        ans += mx;
    }
    return ans;
};