/*
                LINEAR SEARCH 
Definition:
Linear Search is a simple searching technique where
each element of the array is checked sequentially
until the target element is found or the array ends.

Core Idea:
Traverse the array from the first element to the last.
Compare each element with the target value.
If a match is found, return the index of that element.

Algorithm Steps:
1. Start from index 0.
2. Compare nums[i] with target.
3. If equal → return index i.
4. If traversal finishes without a match → return -1.

Example:
nums = [4, 2, 7, 1, 9], target = 1

4 ≠ 1
2 ≠ 1
7 ≠ 1
1 = 1 → return index 3

Complexities:
Time Complexity:
- Best Case   : O(1)  (target found at first position)
- Average Case: O(n)
- Worst Case  : O(n)  (target at last position or not present)

Space Complexity:
O(1) → constant extra space

Properties:
- Works on both sorted and unsorted arrays
- Very simple to implement
- Inefficient for large datasets

Key Interview Points:
- Used when data is small or unsorted
- No preprocessing required
- Faster algorithms like Binary Search require sorted arrays
*/

class Solution {
    public int linearSearch(int nums[], int target) {
      int idx = -1;

      for(int i=0; i<nums.length; i++){
        if(nums[i] == target){
          idx = i;
          break;
        }
      }

      return idx;
    }
}

// Time: O(n)
// Space: O(1)