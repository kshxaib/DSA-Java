/*
        SINGLE NUMBER (FIND UNIQUE ELEMENT)

Definition:
Given an array where:
• Every element appears twice
• Only ONE element appears once

Return the single (unique) element.


Example

Input:
nums = [4,1,2,1,2]

Output:
4


Core Idea

Use XOR (^)

Why XOR Works

Properties:
1. a ^ a = 0  
2. a ^ 0 = a  
3. XOR is commutative and associative  


Key Insight

All duplicate numbers cancel out:

a ^ a = 0

So only unique number remains.


Step-by-Step

nums = [4,1,2,1,2]

xor = 0

xor = 0 ^ 4 = 4  
xor = 4 ^ 1 = 5  
xor = 5 ^ 2 = 7  
xor = 7 ^ 1 = 6  
xor = 6 ^ 2 = 4  

Final result = 4


Your Approach (Correct)

1. Initialize xor = 0
2. XOR all elements
3. Return result


Time Complexity: O(n)

Space Complexity: O(1)
*/

class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;

        for(int i = 0; i < nums.length; i++){
            xor = xor ^ nums[i];
        }

        return xor;
    }
}