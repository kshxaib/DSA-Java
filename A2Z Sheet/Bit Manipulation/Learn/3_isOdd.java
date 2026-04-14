/*
        CHECK ODD OR EVEN (BIT MANIPULATION)

Definition:
Given an integer n,
check whether it is ODD or EVEN.


Example

Input:
n = 5

Output:
true (odd)


Core Idea

Check the LAST BIT (Least Significant Bit).

• If last bit = 1 → number is ODD
• If last bit = 0 → number is EVEN


Step-by-Step
n = 5 → (101)
n & 1 = 101 & 001 = 001 → 1 → odd

n = 4 → (100)
n & 1 = 100 & 001 = 000 → 0 → even


Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    public boolean isOdd(int n) {
        if((n & 1) == 1){
            return true;
        }
        return false;
    }
}