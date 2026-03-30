/*
        COUNT SUBSEQUENCES WITH TARGET SUM

Definition:
Given an array nums and an integer k,
return the number of subsequences
whose sum is equal to k.

Subsequence:
Pick or skip elements WITHOUT changing order.


Example

Input:
nums = [1, 2, 1], k = 2

Output:
2

Explanation:

Valid subsequences:
[2]
[1,1]


Core Idea (Recursion / Backtracking)

At every index, we have 2 choices:

1. Pick the element
2. Do NOT pick the element

We explore all possible subsequences
and count the ones whose sum = k.

-----------------------------------------------------

Why This Works

Every element contributes to two branches:

Pick → sum increases  
Not pick → sum stays same  

Total subsequences = 2^n


Time Complexity: O(2^n)
Because each element has 2 choices.

Space Complexity: O(n)
Recursion stack depth.
*/

class Solution {
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        int index = 0;
        int sum = 0;
        return findCount(nums, index, sum, k);
    }

    public int findCount(int[] nums, int index, int sum, int k) {
        if (index == nums.length) {
            if(sum == k){
                return 1;
            } else {
                return 0;
            }
        }

        // pick
        int left = findCount(nums, index + 1, sum + nums[index], k);

        // not pick
        int right = findCount(nums, index + 1, sum, k);

        return left + right;
    }
}