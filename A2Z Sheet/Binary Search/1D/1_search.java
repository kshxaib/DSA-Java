/*
            BINARY SEARCH
        (RECURSIVE APPROACH)

Problem:
Given a sorted array nums and a target value,
return the index of the target if found.
Otherwise return -1.

Example:
nums = [-1,0,3,5,9,12]
target = 9

Output: 4

Core Idea:

Binary search works only on **sorted arrays**.

Instead of checking every element,
we repeatedly divide the search space into half.


Algorithm Steps:

1. Find middle index:

        mid = start + (end - start) / 2

2. If nums[mid] == target
        return mid

3. If nums[mid] < target
        search in right half

4. If nums[mid] > target
        search in left half


Why we use:
        mid = start + (end - start) / 2

instead of
        (start + end) / 2

Because `(start + end)` can overflow
for very large arrays.


Complexities:
Time Complexity  : O(log n)
Space Complexity : O(log n) (due to recursion stack)

Properties:
- Works only on sorted arrays
- Divide and conquer technique
- Each step halves the search space

Key Interview Points:
• Iterative binary search → O(1) space
• Recursive binary search → O(log n) space
• Must avoid overflow when calculating mid
*/

class Solution {
    public int search(int[] nums, int target) {
       int start = 0;
       int end = nums.length - 1;

       return BS(nums, start, end, target);
    }

    private int BS(int nums[], int start, int end, int target){
        if(start > end){
            return -1;
        }

        int mid = start + (end - start) / 2;

        if(nums[mid] == target){
            return mid;
        }

        if(nums[mid] < target){
            return BS(nums, mid + 1, end, target);
        } else {
            return BS(nums, start, mid - 1, target);
        }
    }
}

// Time: O(log n)
// Space: O(log n)