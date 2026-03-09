/*
            FIND REPEATING AND MISSING NUMBER
        (MATHEMATICAL APPROACH – SUM & SUM OF SQUARES)

Problem:
You are given an array of size n containing numbers
from 1 to n.

One number appears twice (repeating number A)
and one number is missing (missing number B).

Return: [A, B]

Example:
nums = [3,5,4,1,1]

Repeating → 1
Missing   → 2

Output: [1,2]


Core Idea:
Use mathematical formulas for:
1. Sum of first n natural numbers
2. Sum of squares of first n natural numbers

Expected sums:
SN  = n(n+1)/2
S2N = n(n+1)(2n+1)/6

Actual sums from array:
S  = sum(nums)
S2 = sum(nums²)

Mathematical Derivation:
Let:
X = repeating number
Y = missing number

Difference of sums:
S - SN = X - Y

Difference of squares:
S2 - S2N = X² - Y²

Factorize:
X² - Y² = (X - Y)(X + Y)

So:
X + Y = (S2 - S2N) / (S - SN)

Now we have two equations:
1) X - Y
2) X + Y

Solve:
X = ( (X-Y) + (X+Y) ) / 2
Y = X - (X-Y)

Algorithm Steps:

1. Calculate SN and S2N using formulas.
2. Calculate actual S and S2 from array.
3. Compute:

      XMinusY = S - SN
      XPlusY  = (S2 - S2N) / XMinusY

4. Solve equations to get:

      repeating = X
      missing   = Y


Complexities:
Time Complexity  : O(n)
Space Complexity : O(1)

Properties:
- Uses mathematical equations
- Does not modify array
- Constant extra space
*/

class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        long n = nums.length;

        long SN = (n * (n +1))/2;
        long S2N = (n * (n +1) * (2 * n +1))/6;

        long S = 0, S2 = 0;
        for(int i=0; i<n; i++){
            S += nums[i];
            S2 += (long) nums[i] * nums[i];
        }

        long XMinusY = S - SN;
        long XPlusY = (S2 - S2N)/XMinusY;

        long X = (XMinusY + XPlusY)/2;
        long Y = (S2 - S2N)/XMinusY - X;

        return new int[] {(int) X, (int) Y};
    }   
}

// Time: O(n)
// Space: O(1)  