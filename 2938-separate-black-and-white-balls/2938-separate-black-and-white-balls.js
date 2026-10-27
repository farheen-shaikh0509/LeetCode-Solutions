var minimumSteps = function(s) {
    let steps = 0;
    let zeros = 0;
    for (let i = s.length - 1; i >= 0; i--) {
        if (s[i] === '0') {
            zeros++;
        } else {
            steps += zeros;
        }
    }
    return steps;
};