/*
        SEARCH IN ROTATED SORTED ARRAY II
         (BINARY SEARCH WITH DUPLICATES)

Problem:
Given a rotated sorted array that may contain duplicates,
determine whether a target value exists.

Return true if present, otherwise false.


Example 1:
nums = [7,8,1,2,3,3,3,4,5,6]
k = 3

Output: true


Example 2:  
nums = [7,8,1,2,3,3,3,4,5,6]
k = 10

Output: false


Core Idea:
Same idea as rotated binary search,
but duplicates create ambiguity.

Example:

[1,1,1,1,2,1]

Here we cannot determine which side is sorted
because:
nums[start] == nums[mid] == nums[end]

So we shrink the search space.


Duplicate Handling Rule:

If
nums[start] == nums[mid] == nums[end]

We cannot determine sorted side.
So we do:
        start++
        end--


Algorithm Steps:

1. Binary search loop
2. Check if mid == target
3. Handle duplicates
4. Detect sorted half
5. Move search accordingly


Worst Case Scenario:
If array contains many duplicates like:
[1,1,1,1,1,1,1]
We may shrink only one element at a time.
So worst case becomes: O(n)


Complexities:
Average Time Complexity : O(log n)
Worst Case Time         : O(n)
Space Complexity        : O(1)

Key Interview Points:
• Rotated binary search with duplicates
• Must handle ambiguity case
• Worst case degrades to linear time
*/

class Solution {
    public boolean searchInARotatedSortedArrayII(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] == k){
                return true;
            }

            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                start++;
                end--;
                continue;
            }

            if(nums[start] <= nums[mid]){  
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

        return false;
    }
}

// Complexities:
// Average Time Complexity : O(log n)
// Worst Case Time         : O(n)
// Space Complexity        : O(1)