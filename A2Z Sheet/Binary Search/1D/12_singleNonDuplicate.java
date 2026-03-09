/*
        SINGLE ELEMENT IN SORTED ARRAY
        (BINARY SEARCH + INDEX PARITY)

Problem:
Given a sorted array where every element appears
exactly twice except one element that appears once,
find that single element.


Example 1:
nums = [1,1,2,2,3,3,4,5,5,6,6]

Output: 4

Explanation:
Every element appears twice except 4.


Example 2:
nums = [1,1,3,5,5]

Output: 3

Explanation:
3 appears only once.


Core Idea:
In a sorted array with pairs:

Before the single element:
        first index → even
        second index → odd

Example:
[1,1,2,2,3,3,4,5,5]

index:
0 1 | 2 3 | 4 5 | 6 | 7 8

Pairs start at EVEN index.

After the single element:
The pattern shifts:
Pairs start at ODD index.

Notice the shift after the single element.


Key Observation:

Check whether mid index forms a valid pair.

Case 1:
mid is odd and nums[mid] == nums[mid-1]
Pair is correct → single element is on RIGHT.


Case 2:
mid is even and nums[mid] == nums[mid+1]
Pair is correct → single element is on RIGHT.

Otherwise:
Single element lies on LEFT.


Algorithm Steps:
1. Handle edge cases:

        if n == 1
        if first element unique
        if last element unique

2. Binary search from index 1 to n-2.

3. If nums[mid] differs from neighbors
        return nums[mid]

4. Use parity rule to decide search side.


Complexities:
Time Complexity  : O(log n)
Space Complexity : O(1)

Properties:
- Works only for sorted arrays
- Uses binary search with index parity
- Avoids linear scan

Key Interview Points:
Pairs appear as:
        even index → first
        odd index → second

After the single element,
this pattern flips.
*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        int start = 1;
        int end = n - 2;

        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];

        while(start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])
                return nums[mid];

            if((mid % 2 == 1 && nums[mid] == nums[mid-1]) ||
               (mid % 2 == 0 && nums[mid] == nums[mid+1])){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}

// Time: O(log n)
// Space: O(1)