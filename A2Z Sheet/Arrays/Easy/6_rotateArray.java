/*
            ROTATE ARRAY BY K POSITIONS
Definition:
Array rotation shifts elements either left or right by
k positions. The reversal algorithm rotates the array
in-place using three reverse operations.

Core Idea:
For LEFT rotation by k:

1. Reverse first k elements
2. Reverse remaining n-k elements
3. Reverse the entire array

Example:
nums = [1,2,3,4,5,6,7], k = 3

Step 1: Reverse first k
[3,2,1,4,5,6,7]

Step 2: Reverse remaining
[3,2,1,7,6,5,4]

Step 3: Reverse whole array
[4,5,6,7,1,2,3]

Complexities:
Time Complexity  : O(n)
Space Complexity : O(1)

Properties:
- In-place rotation
- Uses reversal technique
- No extra array required

Key Interview Points:
- Always reduce k using k % n
- Prevents unnecessary rotations when k > n
- Reversal algorithm is the optimal solution
  for array rotation without extra space
*/

class Solution {
    public void rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
        reverse(nums, 0, n-1);
    }

    private void reverse(int nums[], int i, int j){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}

// Time: O(n)
// Space: O(1)