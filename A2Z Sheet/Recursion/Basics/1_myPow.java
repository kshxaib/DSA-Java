/*
        POW(x, n) — FAST EXPONENTIATION (BINARY EXPONENTIATION)

Definition:
Implement pow(x, n), which calculates x raised to the power n.

x → base (double)
n → exponent (integer)


Example 1

Input:
x = 2.0, n = 10

Output:
1024.0


Example 2

Input:
x = 2.0, n = -2

Output:
0.25

Explanation:
2^-2 = 1 / (2^2) = 1/4


Core Idea

Instead of multiplying x n times: 
x * x * x * x ...

We use:
Divide & Conquer (Binary Exponentiation)


Why This is Fast
Normal approach: O(n)

Binary exponentiation: O(log n)

Because we divide n by 2 each time.


Handling Negative Powers

If n < 0:

x^(-n) = 1 / (x^n)

So:

x = 1 / x
n = -n

IMPORTANT:
Use long to avoid overflow for n = Integer.MIN_VALUE


Time Complexity: O(log n)
Because we halve n every recursive call.

Space Complexity: O(log n)
Due to recursion stack.
*/

class Solution {
    public double myPow(double x, int n) {
        long N = n;

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return power(x, N);
    }

    private double power(double x, long n) {
        if (n == 1) return x;

        double half = power(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}