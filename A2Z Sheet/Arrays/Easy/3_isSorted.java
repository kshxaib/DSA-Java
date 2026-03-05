/*
            CHECK IF ARRAY IS SORTED 
Definition:
An array is considered sorted in non-decreasing order
if every element is less than or equal to the element
that comes after it.

Core Idea:
Traverse the array and compare every element with its
next element. If any element is greater than the next
element, the array is not sorted.

Algorithm Steps:
1. Traverse the array from index 0 to n-2.
2. Compare current element with the next element.
3. If current > next → array is not sorted.
4. If no violation is found → array is sorted.

Example:
[1, 3, 5, 7]

1 ≤ 3 → OK
3 ≤ 5 → OK
5 ≤ 7 → OK

Array is sorted → return true

Example (Not Sorted):
[1, 4, 3, 7]

4 > 3 → violation → return false

Complexities:
Time Complexity  : O(n) (single traversal)
Space Complexity : O(1) (constant extra space)

Properties:
- Linear scan approach
- In-place check (no extra memory)
- Works for negative numbers and duplicates

Key Interview Points:
- Early exit optimization: stop as soon as disorder is found
- Used as a pre-check in some sorting optimizations
- Checking sortedness cannot be done faster than O(n)
  because each element may need to be inspected.
*/

class Solution {
    public boolean isSorted(ArrayList<Integer> nums) {
        for(int i=0; i<nums.size() -1; i++){
            int curr = nums.get(i);
            int next = nums.get(i+1);
            if(curr > next){
                return false;
            }
        }

        return true;
    }
}

// Time: O(n)
// Space: O(1)