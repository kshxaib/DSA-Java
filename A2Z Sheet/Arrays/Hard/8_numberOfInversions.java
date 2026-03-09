/*
         COUNT INVERSIONS IN ARRAY
        (MERGE SORT BASED APPROACH)

Problem:
Given an array nums, count the number of inversions.
An inversion is a pair (i, j) such that:

nums[i] > nums[j]  and  i < j

Example:
nums = [2,3,7,1,3,5]

Inversions:
(2,1)
(3,1)
(7,1)
(7,3)
(7,5)

Total = 5


Core Idea:
Brute force checks every pair:
for i
   for j>i
      if nums[i] > nums[j]

Time Complexity → O(n²)

Instead, we use Merge Sort.

Why?
During merging we already compare elements from
two sorted halves.

If an element in the right half is smaller than
an element in the left half, then it forms
inversions with ALL remaining elements in the left half.


Key Observation:
During merge:

Left array → nums[low ... mid]
Right array → nums[mid+1 ... high]

If:
nums[i] > nums[j]

Then every element from:
nus[i] → nums[mid]
will be greater than nums[j]

So number of inversions = (mid - i + 1)


Algorithm Steps:

1. Divide array using merge sort.

2. Recursively sort left and right halves.

3. During merge:

      if nums[i] <= nums[j]
            move nums[i]

      else
            move nums[j]
            add inversions = mid - i + 1

4. Continue merging normally.


Complexities:
Time Complexity  : O(n log n)
Space Complexity : O(n) (temp array used in merge)

Properties:
- Uses divide and conquer
- Counts inversions while merging
- Same structure as merge sort

Key Interview Points:
• Brute force → O(n²)
• Optimal → Merge sort technique
• Important formula: inversions += (mid - i + 1)
• Works because both halves are already sorted
*/

class Solution {
    private long merge(int nums[], int low, int mid, int high){
        int temp[] = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        long count = 0;

        while(i <= mid && j <= high){
            if(nums[i] <= nums[j]){
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                count += (mid - i + 1);
                j++;
            }
            k++;
        }

        while(i <= mid){
            temp[k] = nums[i];
            i++;
            k++;
        }

        while(j <= high){
            temp[k] = nums[j];
            j++;
            k++;
        }

        for(int x = low; x <= high; x++){
            nums[x] = temp[x - low];
        }

        return count;
    }

    private long mergeSort(int nums[], int low, int high){
        long count = 0;

        if(low >= high){
            return count;
        }

        int mid = low + (high - low) / 2;

        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += merge(nums, low, mid, high);

        return count;
    }

    public long numberOfInversions(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }
}

// Time: O(n log n)
// Space: O(n)