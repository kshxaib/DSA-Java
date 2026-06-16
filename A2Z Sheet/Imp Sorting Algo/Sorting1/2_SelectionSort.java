/*
Definition:
Selection Sort repeatedly selects the minimum element
from the unsorted part of the array and places it at
the correct position in the sorted part.

Core Idea:
- Divide array into sorted and unsorted parts.
- In each pass:
    1) Find the minimum element in unsorted region.
    2) Swap it with the first unsorted index.
- After every pass, one element is fixed permanently.

Complexities:
- Worst Case  : O(n^2)
- Average Case: O(n^2)
- Best Case   : O(n^2)   (no early optimization)
- Space       : O(1)     (in-place)

Properties:
- In-place
- NOT Stable (due to swapping)
- Comparison-based

Key Interview Points:
- Performs minimum number of swaps (at most n-1).
- Useful when swap operation is costly.
- Time complexity remains O(n^2) even if array is sorted.

Use Cases:
- Small datasets
- Situations where memory writes/swaps must be minimized
- Mostly educational in practice
*/

class Solution {
    public int[] selectionSort(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n-1; i++){
            int minIdx = i;

            for(int j=i+1; j<n; j++){
                if(nums[j] < nums[minIdx]){
                    minIdx = j;
                }
            }   
            swap(nums, i, minIdx);
        }

        return nums;
    }

    private void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
