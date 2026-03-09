/*
        MAXIMUM PRODUCT SUBARRAY
         (PREFIX + SUFFIX SCAN)

Problem:
Given an integer array nums, find the contiguous
subarray with the largest product and return that product.

Example:
nums = [2,3,-2,4]

Subarrays:
[2] → 2
[2,3] → 6
[2,3,-2] → -12
[3,-2,4] → -24
[4] → 4

Maximum product = 6


Core Idea:
Multiplication behaves differently than addition
because negative numbers flip the sign.

Example:
[-2, 3, -4]

Product = 24 (because negative × negative = positive)

So simply tracking a running product from left to right
may miss the correct answer.

To handle this, we scan from BOTH directions.


Prefix and Suffix Idea:
prefix → product from left to right
suffix → product from right to left

Why?
If there is an odd number of negatives,
the best subarray may exclude either
the prefix part or the suffix part.


Algorithm Steps:

1. Initialize:
      prefix = 1
      suffix = 1
      maxProduct = -∞

2. Traverse the array:

      prefix *= nums[i]
      suffix *= nums[n-i-1]

3. Update maxProduct with:

      max(prefix, suffix)

4. If prefix or suffix becomes 0,
   reset it to 1 because product chain breaks.


Why reset when product becomes 0?
Example:
nums = [2,3,0,4]

Once product hits 0,
future multiplication will remain 0.

So we restart multiplication.


Complexities:
Time Complexity  : O(n)
Space Complexity : O(1)

Properties:
- Handles negative numbers correctly
- Works even with multiple zeros
- Uses two directional scans

Key Interview Points:
• Product sign flips with negatives
• Two scans ensure no valid product is missed
• Reset when product becomes zero
*/

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;

        int prefix = 1;
        int suffix = 1;

        for(int i = 0; i < n; i++){

            if(prefix == 0){
                prefix = 1;
            }

            if(suffix == 0){
                suffix = 1;
            }

            prefix *= nums[i];
            suffix *= nums[n - i - 1];

            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }

        return maxProduct;
    }
}

// Time: O(n)
// Space: O(1)