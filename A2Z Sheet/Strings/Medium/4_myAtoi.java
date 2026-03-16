/*
        STRING TO INTEGER (ATOI)

Problem:
Implement the function myAtoi which converts
a string to a 32-bit signed integer.

Rules
1. Ignore leading whitespace.
2. Detect sign (+ or -).
3. Read digits until a non-digit appears.
4. If no digits exist → return 0.
5. Clamp result to 32-bit signed integer range.

Integer Range
MIN = -2147483648   (−2^31)
MAX =  2147483647   (2^31 − 1)


Example 1
Input: "42"

Output: 42


Example 2

Input: "   -042"

Output: -42

Explanation:
Spaces ignored → sign detected → digits read.


Example 3
Input: "1337c0d3"

Output: 1337

Explanation:
Stop when first non-digit appears.


Example 4
Input: "0-1"

Output: 0

Explanation:
Reading stops after '0'.


Core Idea
We process the string in **4 phases**:
1. Skip spaces
2. Detect sign
3. Convert digits
4. Handle overflow


Algorithm Steps
1. Initialize index i
2. Skip leading spaces
3. Detect sign
4. Traverse digits
5. Convert characters to numbers
6. Check overflow before multiplying
7. Build result
8. Return result * sign


Complexities
Time Complexity  : O(n)
We scan the string once.

Space Complexity : O(1)
Only constant variables used.


Key Interview Points
Overflow check trick:  result > (MAX - digit) / 10

This prevents overflow before it happens.
*/

class Solution {

    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        int sign = 1;
        int result = 0;

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        // Step 1: Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Detect sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {

            if (s.charAt(i) == '-') {
                sign = -1;
            }

            i++;
        }

        // Step 3: Convert digits
        while (i < n && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            // Step 4: Overflow check
            if (result > (max - digit) / 10) {
                return sign == 1 ? max : min;
            }

            result = result * 10 + digit;

            i++;
        }

        return result * sign;
    }
}

// Time Complexity  : O(n)
// Space Complexity : O(1)