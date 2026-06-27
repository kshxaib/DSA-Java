
/*
        SUBSETS WITH DUPLICATES (UNIQUE POWER SET)

Definition:
Given an integer array nums (may contain duplicates),
return all possible UNIQUE subsets.


Example

Input:
nums = [1,2,2]

Output:
[
 [],
 [1],
 [1,2],
 [1,2,2],
 [2],
 [2,2]
]


Core Idea (Backtracking + Sorting)

This is an extension of Power Set,
but with duplicates.

Key steps:
1. Sort the array
2. Use backtracking
3. Skip duplicates at SAME recursion level


Why Sorting is Required
Sorting groups duplicates together: [1,2,2] → [1,2,2]

This allows easy detection of duplicates.


Time Complexity: O(2^n)
Worst case (no duplicates)

With duplicates:
less than 2^n due to pruning

Space Complexity: O(n)
Recursion depth
*/
import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        findSubsets(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    public void findSubsets(int[] nums, List<List<Integer>> ans,
            List<Integer> curr, int index) {

        // Every current subset is a valid answer.
        ans.add(new ArrayList<>(curr));

        // Try every element starting from the current index.
        for (int i = index; i < nums.length; i++) {

            // Skip duplicates at the same recursion level.
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose current element.
            curr.add(nums[i]);

            // Explore further subsets.
            findSubsets(nums, ans, curr, i + 1);

            // Backtrack.
            curr.remove(curr.size() - 1);
        }
    }
}