/*
Definition:
Merge Sort is a divide-and-conquer sorting algorithm.
It divides the array into two halves, recursively sorts
each half, and then merges the sorted halves.

Core Idea:
1. Divide the array into two halves.
2. Recursively sort both halves.
3. Merge the two sorted halves into one sorted array.

Example:
[5, 2, 4, 1]

Divide:
[5,2] [4,1]
[5] [2] [4] [1]

Merge:
[2,5] [1,4]
[1,2,4,5]

Complexities:
Worst Case  : O(n log n)
Average Case: O(n log n)
Best Case   : O(n log n)

Space Complexity:
O(n) → extra temporary array required for merging

Properties:
- Stable
- Not in-place (uses extra memory)
- Comparison-based
- Divide and Conquer algorithm

Key Interview Points:
- Guarantees O(n log n) time complexity
- Works well for large datasets
- Used in external sorting (large data on disk)
- Basis of algorithms like TimSort
*/

class Solution {
    public int[] mergeSort(int[] nums) {
        int start = 0;
        int end = nums.length -1;

        perforMS(nums, start, end);
        return nums;
    }

    private void perforMS(int nums[], int start, int end){
        if(start >= end){
            return;
        }

        int mid = start + (end - start)/2;
        perforMS(nums, start, mid);
        perforMS(nums, mid +1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int nums[], int start, int mid, int end){
        int temp[] = new int[end - start + 1];
        int i = start;
        int j = mid +1;
        int k = 0;

        while(i<=mid && j<=end){
            if(nums[i] < nums[j]){
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            temp[k] = nums[i];
            i++;
            k++;
        }

        while(j<=end){
            temp[k] = nums[j];
            j++;
            k++;
        }

        for(int x=start; x<=end; x++){
            nums[x] = temp[x-start];
        }
    }
}

// Time: O(n log n)
// Space: O(n)