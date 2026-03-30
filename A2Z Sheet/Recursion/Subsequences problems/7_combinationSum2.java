/*
        COMBINATION SUM II (NO REUSE + HANDLE DUPLICATES)

Definition:
Given an array candidates (may contain duplicates)
and a target,
return all unique combinations where numbers sum to target.

IMPORTANT:
• Each element can be used ONLY ONCE
• Result must NOT contain duplicate combinations


Example

Input:
candidates = [10,1,2,7,6,1,5], target = 8

Output:
[
 [1,1,6],
 [1,2,5],
 [1,7],
 [2,6]
]


Core Idea (Backtracking + Sorting)

We use:
1. Sorting → to handle duplicates
2. Backtracking → to explore combinations
3. Skip duplicates → to avoid repeated answers


Why Sorting is Required

Sorting helps:
• Detect duplicates easily
• Enable pruning (break when > target)


Time Complexity: O(2^n)
Worst case exploring subsets
But pruning + duplicate skipping reduces work

Space Complexity: O(k)
k = max depth of recursion
*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int index = 0;
        Arrays.sort(candidates);

        findCombinations(candidates, ans, curr, index, target);
        return ans;
    }

    public void findCombinations(int candidates[], List<List<Integer>> ans, List<Integer> curr, int index, int target){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index; i<candidates.length; i++){

            // skip duplicates
            if(i > index && candidates[i] == candidates[i -1]){
                continue;
            }

            // pruning
            if(candidates[i] > target){
                break;
            }

            curr.add(candidates[i]);

            // move to next index (no reuse)
            findCombinations(candidates, ans, curr, i +1, target - candidates[i]);

            // backtrack
            curr.remove(curr.size() -1);
        }
    }
}