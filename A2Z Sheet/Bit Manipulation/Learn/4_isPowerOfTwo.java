/*
        CHECK POWER OF TWO (BIT MANIPULATION)

Definition:
Given an integer n,
return true if it is a power of 2.

Power of 2:
1, 2, 4, 8, 16, 32, ...


Example

Input:
n = 8

Output:
true


Input:
n = 10

Output:
false


Core Idea
A power of 2 has ONLY ONE BIT set.

Examples:

1  → 0001  
2  → 0010  
4  → 0100  
8  → 1000  


Key Trick
n & (n - 1)


Why This Works
For power of 2:

n       = 1000  
n - 1   = 0111  

n & (n-1) = 0000


For non-power:

n       = 1010  
n - 1   = 1001  

n & (n-1) ≠ 0


Step-by-Step
1. Subtract 1 from n
2. AND with original n
3. If result == 0 → power of 2

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        if((n & (n-1)) == 0) return true;
        return false;
    }
}