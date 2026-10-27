/**
 * @param {number[][]} matrix
 * @return {number}
 */
var countSquares = function(matrix) {
    if (!matrix || matrix.length === 0 || matrix[0].length === 0) {
        return 0;
    }
    
    let m = matrix.length;
    let n = matrix[0].length;
    let totalSquares = 0;
    
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (matrix[i][j] === 1) {
                if (i > 0 && j > 0) {
                    matrix[i][j] = Math.min(
                        matrix[i - 1][j],
                        Math.min(matrix[i][j - 1], matrix[i - 1][j - 1])
                    ) + 1;
                }
                totalSquares += matrix[i][j];
            }
        }
    }
    
    return totalSquares;
};