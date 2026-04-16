/*
        XOR OF RANGE [L, R]

Definition:
Find XOR of all numbers from L to R:

L ^ (L+1) ^ (L+2) ^ ... ^ R


Example

Input:
L = 3, R = 6

Output:
3 ^ 4 ^ 5 ^ 6 = 4


Core Idea

Instead of computing XOR one by one (O(n)),
we use a PATTERN:

XOR from 1 → n follows a cycle of 4


Pattern (VERY IMPORTANT)

Let f(n) = XOR from 1 to n
n % 4 == 0 → f(n) = n  
n % 4 == 1 → f(n) = 1  
n % 4 == 2 → f(n) = n + 1  
n % 4 == 3 → f(n) = 0  


Why This Works
XOR pattern repeats every 4 numbers.


Range Formula
XOR(L → R) = XOR(1 → R) ^ XOR(1 → L-1)


Why This Formula Works

Because:

(1 ^ 2 ^ 3 ^ ... ^ R)
^
(1 ^ 2 ^ 3 ^ ... ^ L-1)

Cancels common part → leaves L → R


Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    public int findRangeXOR(int l, int r) {
        int tillLMinus1 = findXorTillN(l -1);
        int tillR = findXorTillN(r);
        return tillLMinus1 ^ tillR;
    }

    public int findXorTillN(int n) {
        if (n % 4 == 0) return n;
        if (n % 4 == 1) return 1;
        if (n % 4 == 2) return n + 1;
        return 0; // n % 4 == 3
    }
}