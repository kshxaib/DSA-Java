/*
        POWER SET (GENERATE ALL SUBSETS)

Definition:
Given an array of unique integers,
generate all possible subsets (power set).

A subset can be:
• empty
• contain some elements
• contain all elements


Example 1

Input:
nums = [1, 2, 3]

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


Example 2

Input:
nums = [1, 2]

Output:
[
 [],
 [1],
 [2],
 [1,2]
]


Core Idea (Backtracking / Recursion)

At every index,
we have TWO choices:
1. Pick the element
2. Do NOT pick the element

This creates a decision tree.


Why This Works

For each element:
Include it OR exclude it

Total subsets: 2^n


index = 0

                []
             /       \
          [1]         []
         /   \       /   \
     [1,2]  [1]   [2]   []
     /   \   / \   / \   / \
[1,2,3][1,2][1,3][1]...

Eventually all combinations form.


Step-by-Step Algorithm

1. Start with empty subset []
2. At index i:
   → include nums[i]
   → exclude nums[i]
3. Move to next index
4. When index == nums.length:
   add current subset to answer


Time Complexity: O(2^n * n)

Explanation:
• Total subsets = 2^n
• Copying subset takes O(n)


Space Complexity: O(n)
Recursion depth = n

(Excluding output storage)
*/

class Solution {
    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        generateAns(ans, curr, 0, nums);
        return ans;
    }

    public void generateAns(List<List<Integer>> ans, List<Integer> curr, int index, int nums[]) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(curr)); 
            return;
        }

        // pick
        curr.add(nums[index]);
        generateAns(ans, curr, index + 1, nums);

        // backtrack
        curr.remove(curr.size() - 1);

        // not pick
        generateAns(ans, curr, index + 1, nums);
    }
}