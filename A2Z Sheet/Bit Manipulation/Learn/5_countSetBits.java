/*
        COUNT SET BITS (NUMBER OF 1s IN BINARY)

Definition:
Given an integer n,
return the number of set bits (1s)
in its binary representation.


Example

Input:
n = 5  → (101)

Output:
2


Core Idea

Check LAST BIT repeatedly
and shift number to the right.


Time Complexity: O(log n) (number of bits in n)
Space Complexity: O(1)
*/

class Solution {
    public int countSetBits(int n) {
        int count = 0;

        while (n > 0) {
            count += (n & 1);
            n = n >> 1;
        }

        return count;
    }
}