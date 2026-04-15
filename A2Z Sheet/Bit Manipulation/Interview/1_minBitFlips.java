/*
        MINIMUM BIT FLIPS TO CONVERT NUMBER

Definition:
Given two integers start and goal,
return the minimum number of bit flips
required to convert start → goal.

A bit flip = changing 0 → 1 or 1 → 0


Example

Input:
start = 10 (1010)
goal  = 7  (0111)

Output:
3

Explanation:
1010 → 0111  
Flip 3 bits


Core Idea

Use XOR (^)
start ^ goal → gives positions where bits differ


Why This Works

XOR result:
Same bits → 0  
Different bits → 1  

So number of 1s in XOR = number of flips needed


Step-by-Step

start = 10 → (1010)  
goal  = 7  → (0111)

XOR:

1010  
0111  
----  
1101  


Time Complexity: O(log N)
(number of bits)

Space Complexity: O(1)
*/

class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int count = 0;

        while(xor > 0){
            count = count + (xor & 1);
            xor = xor >> 1;
        }

        return count;
    }
}