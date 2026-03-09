/*
           SEARCH INSERT POSITION
        (BINARY SEARCH / LOWER BOUND)

Problem:
Given a sorted array nums and a target value,
return the index of the target if it exists.

If the target does not exist,
return the index where it should be inserted
to maintain sorted order.


Example 1:
nums = [1,3,5,6]
target = 5

Output: 2

Explanation:
5 already exists at index 2.


Example 2:
nums = [1,3,5,6]
target = 2

Output: 1

Explanation:
2 is not present.
It should be inserted between 1 and 3.


Example 3:
nums = [1,3,5,6]
target = 7

Output: 4

Explanation:
7 is greater than all elements,
so it should be inserted at the end.


Core Idea:
This problem is exactly the same as
finding the **Lower Bound**.

Lower Bound: first index where nums[i] ≥ target

That position is exactly where the target
should be inserted.


Algorithm Steps:

1. Initialize

        start = 0
        end = n - 1
        ans = n

2. While start ≤ end

        mid = start + (end - start) / 2

3. If nums[mid] ≥ target

        ans = mid
        end = mid - 1

4. Else

        start = mid + 1

5. Return ans


Complexities:
Time Complexity  : O(log n)
Space Complexity : O(1)

Properties:
- Works only on sorted arrays
- Uses modified binary search
- Equivalent to lower bound

Key Interview Points:
Lower Bound condition: nums[mid] ≥ target

This template solves many problems like:
• Search Insert Position
• First Occurrence
• Lower Bound
• Count Occurrences
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        int ans = nums.length;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid] >= target){
                ans = mid;
                end = mid -1;
            } else {
                start = mid +1;
            }
        }

        return ans;
    }
}

// Time: O(log n)
// Space: O(1)