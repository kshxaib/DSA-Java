/*
        CHECK i-th BIT (BIT MANIPULATION)

Definition:
Given an integer n and index i,
check whether the i-th bit is SET (1) or NOT (0).


Example

Input:
n = 5 (binary: 101)
i = 2

Output:
true

Explanation:
Bit at index 2 = 1


Core Idea

Use BIT MASKING.
We create a number with only i-th bit set:

mask = 1 << i

Then perform AND:
n & mask


Why This Works
If i-th bit in n is 1:
n & mask ≠ 0

If i-th bit is 0:
n & mask = 0


Step-by-Step

n = 5 → (101)
i = 1

mask = 1 << 1 = (010)

n & mask = 101 & 010 = 000 → bit is NOT set


Your Code Flow
1. Create leftShift (mask)
2. AND with n
3. Check if result is zero


Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    public boolean checkIthBit(int n, int i) {
        int leftShift = 1 << i;
        int result = n & leftShift;

        if(result == 0){
            return false;
        }

        return true;
    }
}