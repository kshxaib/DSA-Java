/*
        DIVIDE TWO INTEGERS (WITHOUT USING *, /, %)

Definition:
Given two integers dividend and divisor,
divide them WITHOUT using multiplication,
division, or modulus operators.

Return the quotient after division.


Example

Input:
dividend = 10, divisor = 3

Output:
3


Input:
dividend = 7, divisor = -3

Output:
-2


Core Idea (BIT MANIPULATION + SUBTRACTION)

Instead of subtracting divisor repeatedly:
a = a - b - b - b ...

We use:
SHIFTING (fast doubling)


Why This Works
b << shift = b * (2^shift)

So we subtract large chunks instead of one by one.


Time Complexity: O(log N * log N)
Outer loop runs log N times  
Inner loop finds shift (log N)


Space Complexity: O(1)
*/

class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean sign = true;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)){
            sign = false;
        }

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int ans = 0;

        while(a >= b){

            int shift = 0;

            while(a >= (b << (shift + 1))){
                shift++;
            }

            a -= b << shift;
            ans += 1 << shift;
        }

        return sign ? ans : -ans;
    }
}