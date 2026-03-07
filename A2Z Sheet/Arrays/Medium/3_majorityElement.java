/*
                MAJORITY ELEMENT
          (BOYER–MOORE VOTING ALGORITHM)

Problem:
Given an array of size n, find the element that
appears more than n/2 times (majority element).

The problem guarantees that such an element exists.

Example:
nums = [7,0,0,1,7,7,2,7,7]

Count:
7 → 5 times
Array size = 9
5 > 9/2 → majority element = 7

Core Idea:
If an element appears more than n/2 times,
it will survive pairwise cancellations
with other elements.

Boyer–Moore uses this property.

Algorithm Steps:
1. Maintain two variables:
      element → potential majority candidate
      count   → its frequency counter

2. Traverse the array:
      if count == 0 → choose new candidate

3. If current element equals candidate:
      increment count

4. Otherwise:
      decrement count

Because the majority element appears
more than all others combined,
it remains as the final candidate.

Example Walkthrough:
nums = [2,2,1,1,1,2,2]

2 → count=1
2 → count=2
1 → count=1
1 → count=0
1 → new candidate
2 → count=0
2 → new candidate

Final candidate = 2

Complexities:
Time Complexity  : O(n)
Space Complexity : O(1)

Properties:
- Single pass algorithm
- Constant space
- Based on cancellation principle

Key Interview Points:
- Works because majority element > n/2
- If majority wasn't guaranteed,
  a second verification pass is needed
*/

class Solution {
    public int majorityElement(int[] nums) {
        int element = 0;
        int count = 0;

        for(int i=0; i<nums.length; i++){
            if(count == 0){
                element = nums[i];
                count = 1;
            } else if(nums[i] == element){
                count++;
            } else {
                count--;
            }
        } 

        return element;
    }
}

// Time: O(n)
// Space: O(1)