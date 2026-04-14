/*
        CHECK ODD OR EVEN (BIT MANIPULATION)

Definition:
Given an integer n,
check whether it is ODD or EVEN.

-----------------------------------------------------

Example

Input:
n = 5

Output:
true (odd)

-----------------------------------------------------

Core Idea

Check the LAST BIT (Least Significant Bit).

• If last bit = 1 → number is ODD
• If last bit = 0 → number is EVEN

-----------------------------------------------------

Why This Works

Binary Representation:

Even numbers:
...0  → last bit is 0

Odd numbers:
...1  → last bit is 1

-----------------------------------------------------

Bit Trick

n & 1

This extracts the last bit.

-----------------------------------------------------

Step-by-Step

n = 5 → (101)

n & 1 = 101 & 001 = 001 → 1 → odd

-----------------------------------------------------

n = 4 → (100)

n & 1 = 100 & 001 = 000 → 0 → even

-----------------------------------------------------

Your Code Flow

1. Perform (n & 1)
2. Check if result == 1
3. Return true if odd

-----------------------------------------------------

Time Complexity

O(1)

-----------------------------------------------------

Space Complexity

O(1)

-----------------------------------------------------

Key Interview Points

• Faster than using n % 2
• Uses bitwise AND
• Works for both positive and negative numbers

-----------------------------------------------------

Cleaner Version

return (n & 1) == 1;

-----------------------------------------------------

Even Better (More Standard)

return (n & 1) != 0;

Why?

Because:
non-zero → true

-----------------------------------------------------

Common Mistakes

• Using == 1 instead of != 0 (less robust style)
• Confusing bitwise AND with logical AND

-----------------------------------------------------

Important Note

Works for negative numbers too:

-3 → (...11101)
-3 & 1 = 1 → odd

-----------------------------------------------------

Final Brutal Insight

Your logic is correct.

But:
• unnecessary if-else
• slightly verbose

In interviews:
write clean, minimal code.

-----------------------------------------------------
*/

class Solution {
    public boolean isOdd(int n) {
        if((n & 1) == 1){
            return true;
        }
        return false;
    }
}