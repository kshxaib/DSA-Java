/*
Definition:
Insertion Sort builds the sorted array one element at
a time by inserting each element into its correct
position in the already sorted portion of the array.

Core Idea:
- Assume the first element is already sorted.
- Take the next element (key/current).
- Compare it with elements before it.
- Shift larger elements one position to the right.
- Insert the element at its correct position.

Example:
[5, 3, 4, 1]

Pass 1: insert 3 → [3, 5, 4, 1]
Pass 2: insert 4 → [3, 4, 5, 1]
Pass 3: insert 1 → [1, 3, 4, 5]

Complexities:
Worst Case  : O(n^2)  (reverse sorted)
Average Case: O(n^2)
Best Case   : O(n)    (already sorted)

Space Complexity:
O(1) → In-place

Properties:
- Stable
- In-place
- Adaptive (fast for nearly sorted arrays)
- Comparison-based

Key Interview Points:
- Efficient for small datasets
- Performs well for nearly sorted arrays
- Used in hybrid algorithms like TimSort
*/

class Solution {
    public int[] insertionSort(int[] nums) {
        int n = nums.length;
        
        for(int i=1; i<n; i++){
            int curr = nums[i];
            int prev = i -1;

            while(prev >= 0 && nums[prev] > curr){
                nums[prev+1] = nums[prev];
                prev--;
            }

            nums[prev+1] = curr;
        }
        
        return nums;
    }
}

// Time: O(n^2)
// Space: O(1)