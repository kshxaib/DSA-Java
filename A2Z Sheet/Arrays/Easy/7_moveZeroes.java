/*
                MOVE ZEROES TO END
Definition:
Given an array, move all zero elements to the end
while maintaining the relative order of non-zero
elements. The operation must be done in-place.

Core Idea:
Use two pointers.

Step 1:
Find the first zero in the array.
This index becomes the position where the next
non-zero element should be placed.

Step 2:
Traverse the remaining array.

Whenever a non-zero element is found:
- swap it with the element at index i
- increment i

This ensures all non-zero elements shift left
while zeros move to the right.

Example:
Input:
[0,1,4,0,5,2]

Process:
First zero at index 0

swap(0,1) → [1,0,4,0,5,2]
swap(1,4) → [1,4,0,0,5,2]
swap(2,5) → [1,4,5,0,0,2]
swap(3,2) → [1,4,5,2,0,0]

Output:
[1,4,5,2,0,0]

Complexities:
Time Complexity  : O(n)
Space Complexity : O(1)

Properties:
- In-place modification
- Stable (order of non-zero elements preserved)
- Two-pointer technique

Key Interview Points:
- First locate the first zero
- Then push non-zero elements forward
- Avoid unnecessary swaps before first zero
*/

class Solution {
    public void moveZeroes(int[] nums) {
        int i = -1;

        for(int j=0; j<nums.length; j++){
            if(nums[j] == 0){
                i = j;
                break;
            }
        }

        if (i == -1) return;

        for(int j=i+1; j<nums.length; j++){
            if(nums[j] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }
}

// Time: O(n)
// Space: O(1)