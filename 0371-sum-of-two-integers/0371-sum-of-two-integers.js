var getSum = function(a, b) {
    while (b !== 0) {
        // XOR adds bits without carrying
        let sum = a ^ b;

        // AND identifies carry bits; shift left to their next positions
        let carry = (a & b) << 1;

        a = sum;
        b = carry;
    }

    return a;
};