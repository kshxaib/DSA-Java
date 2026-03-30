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
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); 

        findSubsets(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    public void findSubsets(int[] nums, List<List<Integer>> ans,
                            List<Integer> curr, int index) {

        ans.add(new ArrayList<>(curr)); // add at every step

        for (int i = index; i < nums.length; i++) {

            // skip duplicates
            if (i > index && nums[i] == nums[i - 1]) continue;

            curr.add(nums[i]);

            findSubsets(nums, ans, curr, i + 1);

            curr.remove(curr.size() - 1);
        }
    }
}