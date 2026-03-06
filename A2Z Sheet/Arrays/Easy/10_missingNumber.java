/*
            FIND MISSING NUMBER 
Problem:
Given an array containing n distinct numbers taken
from the range [0, n], find the one number that is
missing from the array.

Example:
nums = [3,0,1]

Numbers expected → [0,1,2,3]
Actual numbers   → [3,0,1]

Missing number → 2

Core Idea (Mathematical Formula):
The sum of the first n natural numbers is:

        n * (n + 1) / 2

If we compute:
1. The expected sum of numbers from 0 to n
2. The actual sum of elements in the array

The difference between them gives the missing number.

Algorithm Steps:
1. Calculate sum of all elements in the array.
2. Calculate expected sum using formula n*(n+1)/2.
3. Subtract actual sum from expected sum.
4. The result is the missing number.

Example:
nums = [3,0,1], n = 3

Expected sum = 3*(3+1)/2 = 6
Actual sum   = 3 + 0 + 1 = 4

Missing = 6 - 4 = 2

Complexities:
Time Complexity  : O(n)
Space Complexity : O(1)

Properties:
- Uses mathematical formula
- No extra data structures
- Single pass through array

Key Interview Points:
- Works because exactly one number is missing
- Faster than sorting approach
- Avoids extra memory like HashSet
*/

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int actualSum = 0;
        for(int i=0; i<n; i++){
            actualSum += nums[i];
        }

        int exactSum = n * (n +1)/2;

        int missing = exactSum - actualSum;
        return missing;
    }
}

// Time: O(n)
// Space: O(1)