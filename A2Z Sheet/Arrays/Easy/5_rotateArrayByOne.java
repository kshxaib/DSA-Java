/*
        ROTATE ARRAY BY ONE POSITION 
Definition:
Array rotation shifts elements either left or right.
In left rotation by one position, the first element
moves to the end of the array.

Example:
Input:
[1, 2, 3, 4, 5]

After left rotation by one:
[2, 3, 4, 5, 1]

Core Idea:
1. Store the first element temporarily.
2. Shift all elements one position to the left.
3. Place the stored element at the last index.

Algorithm Steps:
- Save nums[0]
- Shift elements from index 1 → n-1
- Place saved element at index n-1

Complexities:
Time Complexity  : O(n)  (one traversal of array)
Space Complexity : O(1)  (in-place rotation)

Properties:
- In-place operation
- No extra array required
- Linear time complexity

Key Interview Points:
- Works for single left rotation only
- For rotating by k positions, this method becomes
  inefficient (O(n*k))
- Optimal solution for k rotations uses:
  - Reversal Algorithm
  - Cyclic Replacement method
*/

class Solution {
    public void rotateArrayByOne(int[] nums) {
        int firstElement = nums[0];

        for(int i=1; i<nums.length; i++){
            nums[i-1] = nums[i];
        }
        nums[nums.length -1] = firstElement;
    }
}

// Time: O(n)
// Space: O(1)