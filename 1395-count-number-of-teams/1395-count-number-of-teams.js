/**
 * @param {number[]} rating
 * @return {number}
 */
var numTeams = function(rating) {
    let n = rating.length;
    let count = 0;
    
    for (let j = 1; j < n - 1; j++) {
        let leftSmaller = 0;
        let leftLarger = 0;
        let rightSmaller = 0;
        let rightLarger = 0;
        
        for (let i = 0; i < j; i++) {
            if (rating[i] < rating[j]) {
                leftSmaller++;
            } else if (rating[i] > rating[j]) {
                leftLarger++;
            }
        }
        
        for (let k = j + 1; k < n; k++) {
            if (rating[k] > rating[j]) {
                rightLarger++;
            } else if (rating[k] < rating[j]) {
                rightSmaller++;
            }
        }
        
        count += leftSmaller * rightLarger + leftLarger * rightSmaller;
    }
    
    return count;
};