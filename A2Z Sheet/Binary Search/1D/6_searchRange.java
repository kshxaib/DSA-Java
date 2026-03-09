/*
        FIRST AND LAST OCCURRENCE OF TARGET
       (BINARY SEARCH / LOWER + UPPER BOUND)

Problem:
Given a sorted array nums and a target value,
find the starting and ending index of the target.

If the target is not present,
return [-1, -1].


Example 1:
nums = [5,7,7,8,8,10]
target = 8

Output: [3,4]

Explanation:
8 appears at indices 3 and 4.


Example 2:
nums = [5,7,7,8,8,10]
target = 6

Output: [-1,-1]

Explanation:
6 does not exist in the array.


Core Idea:
Since the array is sorted,
we can use Binary Search.

We find:
1. First occurrence using Lower Bound
2. Last occurrence using Upper Bound


Definitions:
Lower Bound: first index where nums[i] ≥ target
Upper Bound: first index where nums[i] > target

Therefore:
First Occurrence  = lowerBound(target)
Last Occurrence   = upperBound(target) - 1


Algorithm Steps:

1. Find lowerBound(target)

2. If index is out of range or
   nums[index] ≠ target

        target does not exist
        return [-1,-1]

3. Otherwise

        first = lowerBound(target)
        last  = upperBound(target) - 1

4. Return [first, last]


Complexities:
Time Complexity  : O(log n)
Space Complexity : O(1)

Properties:
- Uses modified binary search
- Works only on sorted arrays
- Efficiently finds range of duplicates

Key Interview Points:
First Occurrence  → lowerBound(target)
Last Occurrence   → upperBound(target) - 1
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        int lb = lowerBound(nums, target);

        if(lb == n || nums[lb] != target){
            return new int[] {-1, -1};
        }

        int up = upperBound(nums, target) - 1;

        return new int[] {lb, up};
    }

    private int lowerBound(int nums[], int target){
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

    private int upperBound(int nums[], int target){
        int start = 0;
        int end = nums.length -1;
        int ans = nums.length;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid] > target){
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