/**
 * @param {number} n
 * @return {number}
 */
var twoEggDrop = function(n) {
    let x = 0;
    while ((x * (x + 1)) / 2 < n) {
        x++;
    }
    return x;
};