/*
        COMBINATION SUM (UNLIMITED USE OF ELEMENTS)

Definition:
Given an array of distinct integers (candidates)
and a target value,
return all unique combinations where
the chosen numbers sum to target.

IMPORTANT:
• You can use the SAME element multiple times
• Order does NOT matter in combinations


Example

Input:
candidates = [2,3,6,7], target = 7

Output:
[
 [2,2,3],
 [7]
]


Core Idea (Backtracking)

At each index, we have 2 choices:

1. PICK the element (and stay at same index)
2. NOT PICK the element (move to next index)


Why Stay at Same Index?
Because elements can be reused unlimited times.

So after picking:
findCombinations(..., index, target - candidates[index])


Time Complexity: O(2^t * k) (approx)
Where:
t = target
k = average length of combination

More accurately:
depends on branching and pruning.

Space Complexity: O(k)
Recursion depth depends on target / smallest element
*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int index = 0;

        findCombinations(candidates, ans, curr, index, target);
        return ans;
    }

    public void findCombinations(int candidates[], List<List<Integer>> ans, List<Integer> curr, int index, int target) {
        if (index == candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(curr));
            }
            return;
        }

        // pick
        if (candidates[index] <= target) {
            curr.add(candidates[index]);
            target = target - candidates[index];
            findCombinations(candidates, ans, curr, index, target);
            curr.remove(curr.size() -1);
            target = target + candidates[index];
        }

        // not pick
        findCombinations(candidates, ans, curr, index + 1, target);
    }
}       