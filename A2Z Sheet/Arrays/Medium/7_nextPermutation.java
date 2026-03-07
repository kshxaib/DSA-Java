/*
                NEXT PERMUTATION

Problem:
Rearrange the array into the next lexicographically
greater permutation.

If no such permutation exists (array is the highest
possible order), rearrange it to the lowest possible
order (sorted ascending).

Example:
[1,2,3] → next permutation → [1,3,2]

[3,2,1] → last permutation → reset to [1,2,3]

Core Idea:
To get the next permutation:

1. Traverse from right and find the first index
   where nums[i] < nums[i+1].
   This is called the "break point".

2. If no such index exists, the array is in
   descending order → reverse the entire array.

3. Otherwise:
   Find the smallest number greater than nums[idx]
   on the right side.

4. Swap those two numbers.

5. Reverse the remaining suffix to make it the
   smallest possible arrangement.

Example Walkthrough:
nums = [1,2,3]

Step 1: Find break point
2 < 3 → idx = 1

Step 2: Find next larger element
3 > 2 → swap

Array becomes: [1,3,2]
Step 3: Reverse suffix (no change)
Answer → [1,3,2]

Complexities:
Time Complexity  : O(n)
Space Complexity : O(1)

Properties:
- In-place modification
- Lexicographical ordering concept
- Uses reverse and swap operations

Key Interview Points:
- Scan from right to find first decreasing element
- Swap with next greater element
- Reverse suffix to get smallest possible order
*/

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }

        if(idx == -1){
            reverse(nums, 0, n-1);
            return;
        }

        for(int i=n-1; i>idx; i--){
            if(nums[i] > nums[idx]){
                swap(nums, i, idx);
                break;
            }
        }

        reverse(nums, idx+1, n-1);
    }

    private void reverse(int nums[], int i, int j){
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
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