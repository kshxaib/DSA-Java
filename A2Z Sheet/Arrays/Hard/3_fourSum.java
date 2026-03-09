/*
                    4SUM
        (SORTING + TWO POINTER TECHNIQUE)

Problem:
Given an integer array nums and an integer target,
return all unique quadruplets [a,b,c,d] such that:

a + b + c + d = target
The solution set must not contain duplicate quadruplets.

Example:
nums = [1,0,-1,0,-2,2]
target = 0

Output:
[-2,-1,1,2]
[-2,0,0,2]
[-1,0,0,1]

Core Idea:
4Sum is an extension of the 3Sum problem.

1. Sort the array.
2. Fix the first element (i).
3. Fix the second element (j).
4. Use two pointers (k and l) to find the remaining pair.

So we solve:
nums[i] + nums[j] + nums[k] + nums[l] = target


Algorithm Steps:

1. Sort the array.

2. Fix the first number (i)

3. Fix the second number (j)

4. Use two pointers:

      k = j + 1
      l = n - 1

5. While k < l:

      sum = nums[i] + nums[j] + nums[k] + nums[l]

      if sum < target
            k++

      if sum > target
            l--

      if sum == target
            store quadruplet
            move both pointers
            skip duplicates


Important Detail:
Use long while computing sum:
(long) nums[i] + nums[j] + nums[k] + nums[l]
Because integer overflow can happen if values are large.

Complexities:
Time Complexity  : O(n³)
Space Complexity : O(1) (excluding result)


Properties:
- Uses sorting
- Two-pointer technique
- Avoids duplicates

Key Interview Points:   
• Brute force → O(n⁴)
• Optimal solution → O(n³)
• Important to avoid duplicate combinations
• Must handle integer overflow
*/


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for(int i = 0; i<n; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;

            for(int j = i+1; j<n; j++){
                if(j>i+1 && nums[j] == nums[j-1]) continue;

                int k = j+1;
                int l = n-1;

                while(k < l){
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if(sum < target){
                        k++;
                    } else if(sum > target){
                        l--;
                    } else{
                        List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        ans.add(quad);
                        k++;
                        l--;

                        while(k<l && nums[k] == nums[k-1]) k++;
                        while(k<l && nums[l] == nums[l+1]) l--; 
                    }
                }
            }
        }

        return ans;
    }
}

// Time: O(n³)
// Space: O(1) (excluding result)