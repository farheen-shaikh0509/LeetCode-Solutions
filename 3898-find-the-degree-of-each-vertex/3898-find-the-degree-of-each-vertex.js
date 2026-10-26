/**
 * @param {number[][]} matrix
 * @return {number[]}
 */

    var findDegrees = function(matrix) {
    if (!matrix || matrix.length === 0) {
        return [];
    }
    return matrix.map(row => row.reduce((sum, val) => sum + val, 0));

};