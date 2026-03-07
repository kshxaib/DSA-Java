/*
        SORT ARRAY OF 0s, 1s, AND 2s
        (DUTCH NATIONAL FLAG ALGORITHM)
        
Problem:
Given an array containing only 0s, 1s, and 2s,
sort the array in non-decreasing order in-place.

Example:
nums = [1,0,2,1,0]
Output → [0,0,1,1,2]

Core Idea:
Use three pointers to divide the array into regions.

low  → boundary for 0s
mid  → current element being processed
high → boundary for 2s

Array Structure During Algorithm:

[0 ... low-1]      → all 0s
[low ... mid-1]    → all 1s
[mid ... high]     → unknown elements
[high+1 ... n-1]   → all 2s

Algorithm Steps:
1. If nums[mid] == 0
      swap(nums[low], nums[mid])
      low++
      mid++

2. If nums[mid] == 1
      mid++

3. If nums[mid] == 2
      swap(nums[mid], nums[high])
      high--
      (mid does NOT move because swapped element must be checked)

Example Walkthrough:
nums = [1,0,2,1,0]

mid=0 → 1 → move mid
mid=1 → 0 → swap with low
mid=2 → 2 → swap with high
mid=2 → 0 → swap with low

Final:
[0,0,1,1,2]

Complexities:
Time Complexity  : O(n)
Space Complexity : O(1)

Properties:
- In-place sorting
- Single pass through array
- No extra memory required

Key Interview Points:
- Also known as Dutch National Flag algorithm
- Much better than counting sort or normal sort
- Uses partitioning logic similar to Quick Sort
*/

class Solution {
    public void sortZeroOneTwo(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length -1;

        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                mid++;
                low++;
            } else if(nums[mid] == 1){
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// Time: O(n)
// Space: O(1)