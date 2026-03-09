/*
          LOWER BOUND
        (BINARY SEARCH)

Problem:
Given a sorted array nums and a value x,
find the index of the first element that is
greater than or equal to x.

If no such element exists,
return nums.length.


Example 1:
nums = [1,2,4,6,8]
x = 4

Output: 2

Explanation:
nums[2] = 4 which is the first element ≥ 4.


Example 2:

nums = [1,2,4,6,8]
x = 5

Output:
3

Explanation:
nums[3] = 6 which is the first element ≥ 5.


Core Idea:
Lower Bound means: smallest index i such that nums[i] ≥ x

We use Binary Search to efficiently find
the first valid position.

Whenever we find nums[mid] ≥ x,
we store it as a potential answer
and move to the left side
to check if an earlier valid index exists.


Algorithm Steps:

1. Initialize:

        start = 0
        end = n - 1
        ans = n  (default if not found)

2. While start ≤ end:

        mid = start + (end - start) / 2

3. If nums[mid] ≥ x

        ans = mid
        end = mid - 1   (search left)

4. Else

        start = mid + 1 (search right)

5. Return ans


Complexities:
Time Complexity  : O(log n)
Space Complexity : O(1)

Properties:
- Works only on sorted arrays
- Finds the first element ≥ target
- Uses modified binary search

Key Interview Points:
Lower Bound: first index where nums[i] ≥ x
Upper Bound: first index where nums[i] > x

Used in problems like:
• First occurrence of element
• Count occurrences in sorted array
• Search insert position
• Binary search variations
*/

class Solution {
    public int lowerBound(int[] nums, int x) {
        int start = 0;
        int end = nums.length - 1; 
        int ans = nums.length; 

        while(start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid] >= x){
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}

// Time: O(log n)
// Space: O(1)