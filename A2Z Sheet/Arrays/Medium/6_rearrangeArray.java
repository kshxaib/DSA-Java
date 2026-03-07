/*
        REARRANGE ARRAY ELEMENTS BY SIGN

Problem:
Given an array containing equal numbers of positive
and negative integers, rearrange it so that:

1. Positive and negative numbers alternate.
2. The array starts with a positive number.
3. The relative order of positive numbers remains same.
4. The relative order of negative numbers remains same.

Example:
nums = [2,4,5,-1,-3,-4]

Output:
[2,-1,4,-3,5,-4]

Core Idea:
We create a new result array and place:
- positive numbers at even indices
- negative numbers at odd indices

Since the array must start with a positive number:
even index → positive
odd index  → negative

Algorithm Steps:
1. Initialize two pointers:
      posIdx = 0 (even positions)
      negIdx = 1 (odd positions)

2. Traverse the original array:
      if number is positive → place at posIdx
                              posIdx += 2
      if number is negative → place at negIdx
                              negIdx += 2

3. Continue until all elements are placed.

Example Walkthrough:

nums = [2,4,5,-1,-3,-4]

posIdx = 0
negIdx = 1

2  → ans[0] = 2
4  → ans[2] = 4
5  → ans[4] = 5
-1 → ans[1] = -1
-3 → ans[3] = -3
-4 → ans[5] = -4

Final:
[2,-1,4,-3,5,-4]

Complexities:
Time Complexity  : O(n)
Space Complexity : O(n)

Properties:
- Maintains relative order (stable)
- Uses extra array
- Works because positives and negatives are equal

Key Interview Points:
- Even indices store positive numbers
- Odd indices store negative numbers
- Order of elements must be preserved
*/

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int posIdx = 0, negIdx = 1;
        int ans[] = new int[n];

        for(int i=0; i<n; i++){
            if(nums[i] < 0){
                ans[negIdx] = nums[i];
                negIdx += 2;
            } else {
                ans[posIdx] = nums[i];
                posIdx += 2;
            }
        }

        return ans;
    }
}

// Time: O(n)
// Space: O(n)