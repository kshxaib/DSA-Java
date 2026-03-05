/*
Definition:
Quick Sort is a divide-and-conquer sorting algorithm
that selects a pivot element and partitions the array
so that elements smaller than the pivot are placed on
the left and larger elements on the right.

Core Idea:
1. Choose a pivot element.
2. Partition the array around the pivot.
3. Recursively apply Quick Sort on left and right subarrays.

Example:
[8, 3, 5, 2, 7]

Pivot = 7
Partition → [3,5,2] 7 [8]

Then recursively sort:
[3,5,2] and [8]

Complexities:
Best Case   : O(n log n)
Average Case: O(n log n)
Worst Case  : O(n^2) (when pivot produces very unbalanced partitions)

Space Complexity:
O(log n) due to recursion stack

Properties:
- Not Stable
- In-place (no extra array used)
- Divide and Conquer algorithm
- Very fast in practice due to good cache locality

Key Interview Points:
- Worst case occurs when pivot is smallest or largest element
- Random pivot or median-of-three reduces worst-case chances
- Often faster than Merge Sort in practice
- Used in many real-world sorting implementations
*/

class Solution {
    public int[] quickSort(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        
        performQS(nums, start, end);
        return nums;
    }

    private int partition(int nums[], int start, int end){
        int pivot = nums[end];
        int i = start -1;

        for(int j=start; j<end; j++){
            if(nums[j] <= pivot){
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        i++;
        nums[end] = nums[i];
        nums[i] = pivot;

        return i;
    }

    private void performQS(int nums[], int start, int end){
        if(start >= end){
            return;
        }

        int pIdx = partition(nums, start, end);
        performQS(nums, start, pIdx -1);
        performQS(nums, pIdx +1, end);
    }
}

// Time: O(n log n) average, O(n^2) worst
// Space: O(log n) due to recursion