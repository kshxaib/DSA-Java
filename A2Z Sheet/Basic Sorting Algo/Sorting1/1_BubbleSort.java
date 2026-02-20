/*
Definition:
Bubble Sort is a comparison-based sorting algorithm
where adjacent elements are repeatedly compared and
swapped if they are in the wrong order.

Core Idea:
- After each pass, the largest unsorted element
  moves to the end ("bubbles up").
- Repeat until array becomes sorted.

Key Optimization:
- If no swap happens in a pass, the array is already
  sorted → stop early (Best case O(n)).

Complexities:
- Worst Case  : O(n^2)  (reverse sorted)
- Average Case: O(n^2)
- Best Case   : O(n)    (already sorted)
- Space       : O(1)    (in-place)

Properties:
- Stable Sort
- In-place
- Adaptive (with swapped flag)
- Comparison-based

Use Cases:
- Educational purpose
- Very small datasets
- Rarely used in real-world systems
*/

class Solution {
    public int[] bubbleSort(int[] nums) {

        int n = nums.length;

        for(int i = 0; i < n - 1; i++){
            boolean swapped = false;

            for(int j = 0; j < n - 1 - i; j++){
                if(nums[j] > nums[j + 1]){
                    swap(nums, j, j + 1);
                    swapped = true;
                }
            }

            if(!swapped){
                break;
            }
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}