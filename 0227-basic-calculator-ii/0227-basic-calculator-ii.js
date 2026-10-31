/**
 * @param {string} s
 * @return {number}
 */
var calculate = function(s) {
    if (!s || s.length === 0) return 0;
    
    const stack = [];
    let currentNumber = 0;
    let operation = '+';
    const n = s.length;
    
    for (let i = 0; i < n; i++) {
        const char = s[i];
        if (char >= '0' && char <= '9') {
            currentNumber = currentNumber * 10 + (char - '0');
        }
        if ((char < '0' && char !== ' ') || i === n - 1) {
            if (operation === '+') {
                stack.push(currentNumber);
            } else if (operation === '-') {
                stack.push(-currentNumber);
            } else if (operation === '*') {
                stack.push(stack.pop() * currentNumber);
            } else if (operation === '/') {
              stack.push(Math.trunc(stack.pop() / currentNumber));
            }
            
            operation = char;
            currentNumber = 0;
        }
    }
        let result = 0;
    while (stack.length > 0) {
        result += stack.pop();
    }
    
    return result;
};