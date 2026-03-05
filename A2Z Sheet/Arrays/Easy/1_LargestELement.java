/*
Definition:
The largest element in an array is the maximum value
present among all elements.

Core Idea:
Traverse the array once and keep track of the maximum
element encountered so far.

Algorithm Steps:
1. Initialize max with the smallest possible integer.
2. Traverse the array.
3. If current element > max → update max.
4. After traversal, max will contain the largest element.

Example:
[4, 7, 1, 9, 3]

Step 1 → max = 4
Step 2 → max = 7
Step 3 → max = 9

Final Answer → 9

Complexities:
Time Complexity  : O(n)  (single traversal)
Space Complexity : O(1)  (constant extra space)

Properties:
- Linear search approach
- In-place (no extra memory)
- Works for negative numbers because of Integer.MIN_VALUE

Key Interview Points:
- Minimum time required is O(n) because every element
  must be checked at least once.
- Cannot be solved faster than O(n) without assumptions
  about the data.
*/

class Solution {
    public int largestElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }

        return max;
    }
}

// Time: O(n)
// Space: O(1)