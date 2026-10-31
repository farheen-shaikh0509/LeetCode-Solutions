/**
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function(tokens) {
    const stack = [];

    for (const token of tokens) {
        if (token === '+' || token === '-' || token === '*' || token === '/') {
            const b = stack.pop();
            const a = stack.pop(); 
            
            let result = 0;
            if (token === '+') result = a + b;
            else if (token === '-') result = a - b;
            else if (token === '*') result = a * b;
            else if (token === '/') {
                result = Math.trunc(a / b);
            }
            
            stack.push(result);
        } else {
            stack.push(parseInt(token, 10));
        }
    }

    return stack.pop();
};