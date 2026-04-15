/*
        SUBSETS (POWER SET - ALL POSSIBLE SUBSETS)

Definition:
Given an array of unique integers nums,
return ALL possible subsets (power set).

A subset can be:
• empty
• contain some elements
• contain all elements


Example

Input:
nums = [1,2,3]

Output:
[
 [], 
 [1], 
 [2], 
 [1,2], 
 [3], 
 [1,3], 
 [2,3], 
 [1,2,3]
]


Core Idea (BACKTRACKING / RECURSION)

At every index, we have TWO choices:
1. PICK the element
2. DO NOT PICK the element


Why This Works

Each element doubles the number of subsets.

Total subsets = 2^n


Time Complexity: O(2^n * n)
Explanation:
• 2^n subsets
• copying each subset takes O(n)

Space Complexity: O(n)
Recursion stack depth
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        generateAns(nums, ans, curr, 0);
        return ans;
    }

    public void generateAns(int nums[], List<List<Integer>> ans, List<Integer> curr, int index){
        if (index == nums.length) {
            ans.add(new ArrayList<>(curr)); 
            return;
        }

        // pick
        curr.add(nums[index]);
        generateAns(nums, ans, curr, index + 1);

        // backtrack
        curr.remove(curr.size() - 1);

        // not pick
        generateAns(nums, ans, curr, index + 1);
    }
}