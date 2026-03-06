/*
            SINGLE NUMBER
Problem:
Given an array where every element appears twice
except for one element that appears exactly once,
find that single element.

Example:
nums = [1, 2, 2, 4, 3, 1, 4]

Pairs cancel out:
1 ^ 1 = 0
2 ^ 2 = 0
4 ^ 4 = 0

Remaining element = 3

Core Idea (XOR Trick):

XOR has three important properties:

1. a ^ a = 0
2. a ^ 0 = a
3. XOR is commutative and associative

Meaning:
order doesn't matter.

If we XOR all elements:
duplicate numbers cancel out and
only the unique number remains.

Example:
nums = [1,2,2,4,3,1,4]

Step-by-step XOR:

0 ^ 1 = 1
1 ^ 2 = 3
3 ^ 2 = 1
1 ^ 4 = 5
5 ^ 3 = 6
6 ^ 1 = 7
7 ^ 4 = 3

Answer = 3

Complexities:
Time Complexity  : O(n)
Space Complexity : O(1)

Properties:
- No extra data structures
- Uses bit manipulation
- Works because all other elements appear exactly twice

Key Interview Points:
- XOR cancels duplicates automatically
- More efficient than using HashMap or sorting
- Common bit-manipulation interview trick
*/

class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int i=0; i<nums.length; i++){
            xor = xor ^ nums[i];
        }

        return xor;
    }
}

// Time: O(n)
// Space: O(1)