/*
                     3SUM
        (SORTING + TWO POINTER TECHNIQUE)

Problem:
Given an integer array nums, return all unique triplets
[i, j, k] such that:

nums[i] + nums[j] + nums[k] = 0
The solution set must not contain duplicate triplets.

Example:
nums = [-1,0,1,2,-1,-4]

Output:
[[-1,-1,2], [-1,0,1]]

Core Idea:
1. Sort the array first.
2. Fix one element (i).
3. Use two pointers (j and k) to find pairs whose sum
   with nums[i] becomes 0.

So we solve:
nums[i] + nums[j] + nums[k] = 0

which becomes:
nums[j] + nums[k] = -nums[i]

Algorithm Steps:
1. Sort the array.

2. Iterate i from 0 → n-1

3. Skip duplicate elements for i
   (to avoid duplicate triplets)

4. Initialize:
      j = i + 1
      k = n - 1

5. While j < k:
      sum = nums[i] + nums[j] + nums[k]
      if sum < 0
            j++   (increase sum)

      if sum > 0
            k--   (decrease sum)

      if sum == 0
            store triplet
            move both pointers

            skip duplicates for j
            skip duplicates for k


Why Sorting Helps:
Sorting allows us to use the two-pointer technique
and also helps avoid duplicates.

Complexities:
Time Complexity  : O(n²)
Space Complexity : O(1) (excluding result)


Properties:
- Uses sorting
- Uses two-pointer pattern
- Avoids duplicate triplets

Key Interview Points:
• Brute force solution → O(n³)
• HashSet solution → O(n²) but extra space
• Optimal solution → Sorting + two pointers
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for(int i=0; i<n; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = n -1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                
                if(sum < 0){
                    j++;
                } else if (sum > 0){
                    k--;
                } else {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(triplet);
                    j++;
                    k--;

                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }

       return ans; 
    }
}

// Time: O(n²)
// Space: O(1) (excluding result)