/*
        FIND NUMBER OF ROTATIONS IN A SORTED ARRAY
                    (BINARY SEARCH)

Problem:
Given a sorted array that has been rotated
unknown number of times, determine how many
times it was rotated.

The array contains DISTINCT elements.


Example 1:
nums = [4,5,6,7,0,1,2,3]

Output: 4

Explanation:
Original array: [0,1,2,3,4,5,6,7]

After 4 right rotations: [4,5,6,7,0,1,2,3]


Example 2:
nums = [3,4,5,1,2]

Output: 3

Explanation:
Original array: [1,2,3,4,5]
After 3 rotations: [3,4,5,1,2]


Core Idea:
The number of rotations equals the
index of the minimum element.

Because rotation moves the smallest element
from index 0 to some new position.


Algorithm Steps:

1. Initialize:

        start = 0
        end = n - 1
        min = +∞
        minIdx = -1

2. While start ≤ end

3. Compute mid.

4. If left half sorted

        update min with nums[start]
        move to right half

5. Else

        update min with nums[mid]
        move to left half

6. Continue until search finishes.


Complexities:
Time Complexity  : O(log n)
Space Complexity : O(1)

Properties:
- Uses modified binary search
- Works only with DISTINCT values
- Finds pivot element
*/

class Solution {
    public int findKRotation(ArrayList<Integer> nums) {
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = nums.size() -1;
        int minIdx = -1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(nums.get(start) <= nums.get(mid)){
                if(nums.get(start) < min){
                    min = nums.get(start);
                    minIdx = start;
                }
                start = mid +1;
            } else {
                if(nums.get(mid) < min){
                    min = nums.get(mid);
                    minIdx = mid;
                }
                end = mid -1;
            }
        }

        return minIdx;
    }
}

// Time: O(log n)
// Space: O(1)