/*
                  REVERSE PAIRS
        (MERGE SORT + TWO POINTER COUNTING)

Problem:
Given an array nums, count the number of reverse pairs.

A reverse pair is defined as:
nums[i] > 2 * nums[j]  AND  i < j

Example:
nums = [1,3,2,3,1]

Reverse pairs:
(3,1)
(3,1)

Output: 2

Core Idea:

Brute force:
for i
    for j > i
        if nums[i] > 2 * nums[j]

Time Complexity → O(n²)
Too slow.

Instead we use **Merge Sort**.

Why?
Merge sort divides the array into two sorted halves.
While merging we can efficiently count reverse pairs.


Key Observation:
Left half  → nums[low ... mid]
Right half → nums[mid+1 ... high]

If:
nums[i] > 2 * nums[j]

Then all elements after j will also satisfy the condition
because the right half is sorted.

So we move pointer `right` forward.


Algorithm Steps:

1. Divide array using merge sort.
2. Recursively solve left and right halves.
3. Count reverse pairs between halves.
4. Merge the two sorted halves.


Counting Logic:
For every element in left half:

    while nums[i] > 2 * nums[right]
           right++

Then number of valid pairs is: right - (mid + 1)


Important Detail:
Use long for multiplication:
(long) nums[i] > 2 * (long) nums[right]

This prevents integer overflow.

Complexities:   
Time Complexity  : O(n log n)
Space Complexity : O(n) (temp array used in merge)

Properties:
- Uses divide and conquer
- Extension of inversion count problem
- Uses two-pointer technique during merge

Key Interview Points:   
• Brute force → O(n²)
• Optimal → Merge sort counting
• Count pairs BEFORE merging
• Important condition: nums[i] > 2 * nums[j]
*/

class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }

    private int mergeSort(int nums[], int low, int high){
        int count = 0;

        if(low >= high){
            return count;
        }

        int mid = low + (high - low) / 2;

        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);

        count += countPairs(nums, low, mid, high);

        merge(nums, low, mid, high);

        return count;
    }

    private int countPairs(int nums[], int low, int mid, int high){
        int count = 0;
        int right = mid + 1;

        for(int i = low; i <= mid; i++){
            while(right <= high && (long)nums[i] > 2L * nums[right]){
                right++;
            }

            count += right - (mid + 1);
        }

        return count;
    }

    private void merge(int nums[], int low, int mid, int high){
        int temp[] = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= high){
            if(nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while(i <= mid){
            temp[k++] = nums[i++];
        }

        while(j <= high){
            temp[k++] = nums[j++];
        }

        for(int x = low; x <= high; x++){
            nums[x] = temp[x - low];
        }
    }
}

// Time: O(n log n)
// Space: O(n)