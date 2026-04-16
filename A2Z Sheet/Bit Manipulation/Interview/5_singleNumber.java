/*
        SINGLE NUMBER II (TWO UNIQUE ELEMENTS)

Definition:
Given an array where:
• Every element appears exactly twice
• Only TWO elements appear once

Return those two unique elements.


Example

Input:
nums = [1,2,1,3,2,5]

Output:
[3,5]


Core Idea (XOR + BIT PARTITION)
Step 1:
XOR all elements

Result:
xor = a ^ b

(where a and b are the two unique numbers)


Why This Works
All duplicates cancel out:

x ^ x = 0

So only:
a ^ b remains


Step 2:
Find a DIFFERENT BIT between a and b

We find first set bit in xor

This bit tells:
a and b differ at this position


Step 3:
Divide numbers into 2 groups

Group 1 → bit is SET  
Group 2 → bit is NOT SET  


Step 4:
XOR each group separately

Each group will give one unique number


Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {    
    public int[] singleNumber(int[] nums) {        
        int xor = 0;
        for(int i=0; i<nums.length; i++){
            xor = xor ^ nums[i];
        }

        // first different bit
        int shift = 0;
        while(xor > 0){
            if((xor & 1) == 0){
                shift++;
                xor = xor >> 1;
            } else {
                break;
            }
        }

        int setBucket = 0;
        int unsetBucket = 0;

        for(int i=0; i<nums.length; i++){
            if(((nums[i] >> shift) & 1) == 1){
                setBucket = setBucket ^ nums[i];
            } else {
                unsetBucket = unsetBucket ^ nums[i];
            }
        }

        if(setBucket > unsetBucket){
            return new int[] {unsetBucket, setBucket};
        } else {
            return new int[] {setBucket, unsetBucket};
        }
    }
}