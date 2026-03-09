/*
        FLOOR AND CEIL IN SORTED ARRAY
               (BINARY SEARCH)

Problem:
Given a sorted array nums and a value x,
find:

1. Floor → largest element ≤ x
2. Ceil  → smallest element ≥ x

Return both values as an array:
[floor, ceil]

If either does not exist, return -1 for that value.


Example 1:
nums = [1,2,4,6,8]
x = 5

Floor → 4
Ceil  → 6

Output: [4,6]


Example 2:
nums = [1,2,4,6,8]
x = 0

Floor → -1
Ceil  → 1

Output: [-1,1]


Example 3:
nums = [1,2,4,6,8]
x = 10

Floor → 8
Ceil  → -1

Output: [8,-1]


Core Idea:
Since the array is sorted,
we can use Binary Search to locate
floor and ceil efficiently.


Floor Definition: largest element ≤ x

Binary search rule:

If nums[mid] ≤ x
        possible floor
        move right (start = mid + 1)

Else
        move left


Ceil Definition: smallest element ≥ x

Binary search rule:

If nums[mid] ≥ x
        possible ceil
        move left (end = mid - 1)

Else
        move right


Algorithm Steps:

1. Use binary search to find floor.
2. Use binary search to find ceil.
3. Return both values.


Complexities:
Time Complexity  : O(log n)
Space Complexity : O(1)

Properties:
- Works only on sorted arrays
- Uses binary search twice
- Efficient lookup for bounds

Key Interview Points:
Floor  → largest element ≤ x
Ceil   → smallest element ≥ x

Relation with bounds:

Lower Bound → first index where nums[i] ≥ x
Upper Bound → first index where nums[i] > x
*/

class Solution {
    public int[] getFloorAndCeil(int[] nums, int x) {
        int start = 0;
        int end = nums.length -1;

        int flr = floor(nums, start, end, x);
        int cl = ceil(nums, start, end, x);

        return new int[] {flr, cl};
    }

    private int floor(int nums[], int start, int end, int x){
        int ans = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] <= x){
                ans = nums[mid];
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    private int ceil(int nums[], int start, int end, int x){
        int ans = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] >= x){
                ans = nums[mid];
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