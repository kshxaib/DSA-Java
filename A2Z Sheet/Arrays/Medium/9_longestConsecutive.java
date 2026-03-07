/*
        LONGEST CONSECUTIVE SEQUENCE

Problem:
Given an unsorted array of integers, find the length
of the longest sequence of consecutive numbers.

The sequence elements must appear consecutively
(e.g., 1,2,3,4) but they do NOT have to be adjacent
in the array.

Example:
nums = [100,4,200,1,3,2]

Consecutive sequence:
[1,2,3,4]

Answer → 4

Core Idea:
Checking consecutive numbers by sorting would take
O(n log n), but we can solve it in O(n) using a HashSet.

The trick is:
Only start counting when the number is the START of
a sequence.

A number is the start of a sequence if:
(num - 1) does NOT exist in the set.

Example:
set = {1,2,3,4}

Start sequence only at:
1 (because 0 is not in set)

Then expand forward:
1 → 2 → 3 → 4

Algorithm Steps:
1. Insert all elements into a HashSet.
2. Traverse through the set.
3. For each number:
      if (num - 1) is NOT in set
            start counting sequence
4. Count forward while (num + 1) exists.
5. Track maximum sequence length.

Example Walkthrough:
nums = [100,4,200,1,3,2]

Set = {100,4,200,1,3,2}

100 → start → length = 1
4   → not start (3 exists)
200 → start → length = 1
1   → start → expand → 1,2,3,4 → length = 4

Answer = 4


Complexities:
Time Complexity  : O(n)
Space Complexity : O(n)

Properties:
- Uses HashSet for O(1) lookup
- Avoids sorting
- Each number visited at most once

Key Interview Points:
- Start counting only if (num-1) doesn't exist
- Prevents rechecking entire sequences
- Reduces complexity from O(n log n) to O(n)
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        
        if(n == 0) return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){
            set.add(nums[i]);
        }

        for(int num : set){
            if(!set.contains(num -1)){
                int count = 1;
                int x = num;

                while(set.contains(x + 1)){
                    count++;
                    x++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}

// Time: O(n)
// Space: O(n)