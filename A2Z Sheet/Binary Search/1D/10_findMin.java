/*
        FIND MINIMUM IN ROTATED SORTED ARRAY
                 (BINARY SEARCH)

Problem:
Given a sorted array that has been rotated at an
unknown pivot, find the minimum element.

The array contains DISTINCT values.

Example 1:
nums = [4,5,6,7,0,1,2,3]

Output: 0

Explanation:
0 is the smallest element in the array.


Example 2:
nums = [3,4,5,1,2]
Output: 1

Explanation:
1 is the smallest element.


Algorithm Steps:
1. Initialize:

        start = 0
        end = n - 1
        min = +∞

2. While start ≤ end

3. Compute mid.

4. Check which half is sorted.

5. Update min accordingly.

6. Move to the unsorted side.


Complexities:
Time Complexity  : O(log n)
Space Complexity : O(1)

Properties:
- Uses modified binary search
- Works only for DISTINCT values
- Exploits sorted half property

Key Interview Points:
If arr[start] ≤ arr[mid]

        left half sorted

Else

        right half sorted

Minimum lies in the UNSORTED region.
*/


// Time: O(log n)
// Space: O(1)

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[low] <= nums[mid]) {
                min = Math.min(min, nums[low]);
                low = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                high = mid - 1;
            }
        }

        return min;
    }
}