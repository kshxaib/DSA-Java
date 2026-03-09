/*
        MERGE TWO SORTED ARRAYS (IN-PLACE)
             (THREE POINTER TECHNIQUE)

Problem:
You are given two sorted arrays:

nums1 of size m + n
nums2 of size n

The first m elements of nums1 are valid numbers
and the last n positions are empty (0s) to store nums2.

Merge nums2 into nums1 so that the final array
is sorted in non-decreasing order.


Example:
nums1 = [1,3,5,0,0,0]
nums2 = [2,4,6]

Result:
[1,2,3,4,5,6]


Core Idea:
Instead of merging from the beginning,
we merge from the end of the arrays.

Why?
Because nums1 already contains values,
and writing from the front would overwrite them.

So we fill the array from the back.

Three Pointers:
i → last element of nums1's valid portion
j → last element of nums2
k → last position of nums1 (m + n - 1)


Algorithm Steps:

1. Set pointers:
      i = m - 1
      j = n - 1
      k = m + n - 1

2. Compare nums1[i] and nums2[j]

      larger value goes to nums1[k]

3. Move pointers accordingly.

4. Continue until nums2 is fully merged.


Why loop condition is (j >= 0)?
Because if nums1 elements finish first,
remaining nums2 elements must still be copied.

But if nums2 finishes first,
nums1 is already correctly placed.

Complexities:
Time Complexity  : O(m + n)
Space Complexity : O(1)

Properties:
- In-place merging
- Uses three pointers
- Avoids extra memory

Key Interview Points:
• Merge from the end to avoid overwriting values
• Only need to check nums2 exhaustion
• Classic two-pointer merging technique
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; 
        int j = n - 1; 
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }
}

// Time: O(m + n)
// Space: O(1)