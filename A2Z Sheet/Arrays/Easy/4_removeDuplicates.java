/*
        REMOVE DUPLICATES FROM SORTED ARRAY
Definition:
Given a sorted array, remove duplicate elements in-place
such that each unique element appears only once.

Return the number of unique elements.

Core Idea (Two Pointer Technique):
- Use pointer i to track the last unique element.
- Use pointer j to scan the array.
- When a new unique element is found, move it to i+1.   

Example:
Input:
[1,1,2,2,3]

Process:
i=0

j=1 → duplicate
j=2 → new element → move to index 1
j=3 → duplicate
j=4 → new element → move to index 2

Array becomes:
[1,2,3,_,_]

Return: 3

Complexities:
Time Complexity  : O(n)
Space Complexity : O(1)

Key Interview Points:
- Works only because the array is already sorted
- Uses two-pointer technique
- No extra memory is used
- Modifies array in-place
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;

        for(int j = 1; j < nums.length; j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}

// Time: O(n)
// Space: O(1)