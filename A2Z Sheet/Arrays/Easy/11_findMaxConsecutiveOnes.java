/*
        MAX CONSECUTIVE ONES
Problem:
Given a binary array (containing only 0s and 1s),
find the maximum number of consecutive 1s.

Example:
nums = [1,1,0,1,1,1]

Process:
1 → count = 1
1 → count = 2
0 → reset count
1 → count = 1
1 → count = 2
1 → count = 3

Maximum consecutive ones = 3

Core Idea:
Use a running counter to track the current streak of 1s.
Whenever a 0 appears, reset the counter.

Algorithm Steps:
1. Initialize two variables:
   - count → current consecutive 1s
   - max → maximum consecutive 1s found so far
2. Traverse the array.
3. If element == 1 → increase count.
4. Update max using Math.max().
5. If element == 0 → reset count to 0.
6. After traversal, max contains the answer.

Example Walkthrough:
nums = [1,1,0,1,1,1]

i=0 → count=1, max=1
i=1 → count=2, max=2
i=2 → reset count
i=3 → count=1
i=4 → count=2
i=5 → count=3, max=3

Answer = 3

Complexities:
Time Complexity  : O(n)
Space Complexity : O(1)

Properties:
- Single traversal
- No extra data structures
- Uses simple counting technique

Key Interview Points:
- Works only for binary arrays
- Pattern: "streak / run length counting"
- Similar logic used in many problems like:
  - longest substring
  - sliding window problems
  - longest increasing streak
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
       int count = 0;
       int max = 0;
       
       for(int i=0; i<nums.length; i++){
          if(nums[i] == 1){
            count++;
            max = Math.max(max, count);
          } else {
            count = 0;
          }
       } 

       return max;
    }
}

// Time: O(n)
// Space: O(1)