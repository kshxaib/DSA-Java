/*
            MAXIMUM SUBARRAY SUM (KADANE'S ALGORITHM)

Problem:
Given an integer array nums, find the contiguous
subarray (containing at least one number) which has
the largest sum and return its sum.

Example:
nums = [-2,1,-3,4,-1,2,1,-5,4]

Maximum subarray:
[4,-1,2,1] → sum = 6

Core Idea:
If the running sum becomes negative, it will only
reduce the sum of any future subarray.

So we reset the running sum to 0 whenever it becomes
negative.

Kadane’s algorithm keeps track of:
1. Current running sum of subarray
2. Maximum subarray sum found so far

Algorithm Steps:
1. Initialize:
      sum = 0
      maxSubarraySum = -∞

2. Traverse array:
      add current element to sum

3. Update maximum sum:
      maxSubarraySum = max(maxSubarraySum, sum)

4. If sum becomes negative:
      reset sum = 0

Example Walkthrough:
nums = [-2,1,-3,4,-1,2,1,-5,4]

sum=-2 → max=-2 → reset
sum=1  → max=1
sum=-2 → reset
sum=4  → max=4
sum=3  → max=4
sum=5  → max=5
sum=6  → max=6
sum=1
sum=5

Final Answer = 6

Complexities:
Time Complexity  : O(n)
Space Complexity : O(1)

Properties:
- Single pass algorithm
- Greedy technique
- Works for negative numbers
- Most optimal solution

Key Interview Points:
- Reset sum when it becomes negative
- Track maximum sum at every step
- If all numbers are negative, the algorithm still
  works because maxSubarraySum starts at -∞
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSubarraySum = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            maxSubarraySum = Math.max(maxSubarraySum, sum);

            if(sum < 0){
                sum = 0;
            }
        }

        return maxSubarraySum;
    }
}

// Time: O(n)
// Space: O(1)