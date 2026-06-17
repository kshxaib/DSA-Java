/*
        ROTATE ARRAY

LeetCode 189

Definition:
Given an integer array nums
and an integer k,

Rotate the array to the right
by k steps.


Example 1

Input:
nums = [1,2,3,4,5,6,7]
k = 3

Output:
[5,6,7,1,2,3,4]



Core Idea (Reversal Algorithm)

Instead of shifting elements
one by one,

use 3 reversals.

Example

nums = [1,2,3,4,5,6,7]
k = 3

Step 1
Reverse entire array
[7,6,5,4,3,2,1]

Step 2
Reverse first k elements
[5,6,7,4,3,2,1]

Step 3
Reverse remaining elements
[5,6,7,1,2,3,4]



Why k % n ?

Suppose:

n = 7
k = 10

Rotating 10 times is same as
rotating 3 times.

Because:

10 % 7 = 3


Algorithm
1. k = k % n
2. Reverse whole array
3. Reverse first k elements
4. Reverse remaining elements


Why This Works
After reversing the whole array,
the last k elements come to front
but in reverse order.

Second reversal fixes the order
of first k elements.

Third reversal fixes the order
of remaining elements.


Time Complexity
Reverse whole array     → O(n)
Reverse first k         → O(k)
Reverse remaining       → O(n-k)
Total: O(n)

Space Complexity: O(1)
In-place rotation.
*/

class Solution {

    public void rotate(int[] nums, int k) {

        int n = nums.length;

        // Handle k greater than array length
        k = k % n;

        // Step 1: Reverse complete array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse remaining elements
        reverse(nums, k, n - 1);
    }

    private void reverse(int nums[], int i, int j) {

        // Standard array reversal
        while(i < j) {

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }
}