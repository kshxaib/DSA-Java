/*
Definition:
The second largest element in an array is the largest
value that is strictly smaller than the maximum element.

Core Idea:
Maintain two variables:
1. largest  → stores the maximum element
2. secondL  → stores the second largest element

Algorithm Steps:
1. Assume first element is the largest.
2. Traverse the array once.
3. If current element > largest:
      update secondL = largest
      update largest = current element
4. Else if current element is between largest and secondL:
      update secondL
5. Ignore elements equal to the largest.

Example:
[4, 7, 1, 9, 3]

largest = 4
→ 7 → largest = 7, second = 4
→ 1 → ignore
→ 9 → largest = 9, second = 7
→ 3 → ignore

Answer = 7

Complexities:
Time Complexity  : O(n)  (single traversal)
Space Complexity : O(1)

Important Edge Cases:
- Array size < 2 → second largest doesn't exist
- All elements equal → no second largest
- Arrays with negative numbers

Key Interview Points:
- Sorting is NOT optimal (O(n log n))
- Best solution uses single pass O(n)
*/

class Solution {
    public int secondLargestElement(int[] nums) {
        int largest = nums[0];
        int secondL = -1;

        for(int i=1; i<nums.length; i++){
            if(nums[i] == largest){
                continue;
            }

            if(nums[i] > largest){
                secondL = largest;
                largest = nums[i];
            } else if(nums[i] > secondL){
                secondL = nums[i];
            }
        }

        return secondL;
    }
}

// Time: O(n)
// Space: O(1)