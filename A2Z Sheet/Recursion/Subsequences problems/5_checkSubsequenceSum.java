/*
        CHECK IF SUBSEQUENCE WITH TARGET SUM EXISTS

Definition:
Given an array nums and integer k,
return true if there exists ANY subsequence
whose sum = k.

Otherwise return false.


Example

Input:
nums = [1, 2, 3], k = 5

Output:
true

Explanation:
Subsequence [2,3] = 5


Core Idea (Recursion / Backtracking)

At every index, we have 2 choices:

1. Pick the element
2. Do NOT pick the element

We stop EARLY when we find a valid subsequence.


Visualization
nums = [1,2,3], k = 5

Tree:

                sum=0
            /            \
         +1               skip
        /   \            /     \
     +2     skip      +2      skip
    / \     /  \      / \     /  \
  +3  skip ...        ...    ...

Path:
1 → 2 → 3 = 6 (reject)
1 → skip → 3 = 4 (reject)
skip → 2 → 3 = 5 ✓ → STOP


Time Complexity
Worst case: O(2^n)

But due to early stopping,
it can be faster in practice.

Space Complexity: O(n)
Recursion stack.
*/

class Solution {
    public boolean checkSubsequenceSum(int[] nums, int k) {
        return checkSum(nums, 0, 0, k);
    }

    public boolean checkSum(int nums[], int index, int sum, int k){
        if(index == nums.length){
            if(sum == k){
                return true;
            }
            return false;
        }

        // pick
        sum += nums[index];
        if(checkSum(nums, index +1, sum, k)){
            return true;
        }

        // backtrack
        sum -= nums[index];

        // not pick
        if(checkSum(nums, index +1, sum, k)){
            return true;
        }

        return false;
    }
}