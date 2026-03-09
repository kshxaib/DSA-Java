/*
        SEARCH IN ROTATED SORTED ARRAY
                (BINARY SEARCH)

Problem:
Given a sorted array that has been rotated at an
unknown pivot, find the index of target k.

If the target is not present,
return -1.

The array contains DISTINCT values.


Example 1:
nums = [4,5,6,7,0,1,2]
k = 0

Output: 4

Explanation:
0 is present at index 4.


Example 2:
nums = [4,5,6,7,0,1,2]
k = 3

Output: -1

Explanation:
3 does not exist in the array.


Core Idea:
Even though the array is rotated,
at least ONE HALF of the array will always
remain sorted.


Key Observation:
If:

        nums[start] ≤ nums[mid]

Then LEFT HALF is sorted.

Otherwise:

        RIGHT HALF is sorted.


Complexities:
Time Complexity  : O(log n)
Space Complexity : O(1)

Properties:
- Uses modified binary search
- Works only when elements are DISTINCT
- At least one side remains sorted


Key Interview Points:
If nums[start] ≤ nums[mid]

        LEFT HALF sorted

Else

        RIGHT HALF sorted
*/

class Solution {
    public int search(int[] nums, int k) {
       int start = 0;
       int end = nums.length - 1;

       while(start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid] == k){
                return mid;
            }

            if(nums[start] <= nums[mid]) {   
                if(nums[start] <= k && k < nums[mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {                         
                if(nums[mid] < k && k <= nums[end]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
       }

       return -1;
    }
}

// Time: O(log n)
// Space: O(1)