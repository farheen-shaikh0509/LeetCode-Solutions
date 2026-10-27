/**
 * @param {number[]} nums
 * @return {number}
 */
var countSubarrays = function(nums) {
    let count = 0;
    let curr = 0;
    for (let i = 0; i < nums.length; i++) {
        if (i > 0 && nums[i] > nums[i - 1]) {
            curr++;
        } else {
            curr = 1;
        }
        count += curr;
    }
    return count;
};