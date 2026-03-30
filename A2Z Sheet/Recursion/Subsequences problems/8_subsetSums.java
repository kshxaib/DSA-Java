/*
        SUBSET SUMS (ALL POSSIBLE SUMS OF SUBSETS)

Definition:
Given an array nums,
return a list containing the sum of every possible subset.

Subset:
Pick or skip each element.


Example

Input:
nums = [1, 2]

Output:
[3, 1, 2, 0]

Explanation:

Subsets:
[1,2] → 3  
[1]   → 1  
[2]   → 2  
[]    → 0  


Core Idea (Pick / Not Pick)

At each index, we have 2 choices:
1. Include the element → add to sum
2. Exclude the element → sum remains same


Time Complexity: O(2^n)
Each element has 2 choices.

Space Complexity: O(n)
Recursion depth.

(Excluding output storage)
*/

class Solution {
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int sum = 0;
        int index = 0;

        findSubset(nums, ans, sum, index);
        return ans;
    }

    public void findSubset(int nums[], List<Integer> ans, int sum, int index){
        if(index == nums.length){
            ans.add(sum);
            return;
        }

        // pick
        sum += nums[index];
        findSubset(nums, ans, sum, index +1);

        // backtrack
        sum -= nums[index];

        // not pick
        findSubset(nums, ans, sum, index +1);
    }
}   