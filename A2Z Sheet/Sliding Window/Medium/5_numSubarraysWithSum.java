/*
        BINARY SUBARRAYS WITH SUM

Definition:
Given a binary array nums[] (only 0 and 1)
and integer goal,

Return number of subarrays
whose sum = goal.


Example 1

Input:
nums = [1,0,1,0,1]
goal = 2

Output:
4

Subarrays:
[1,0,1]
[1,0,1,0]
[0,1,0,1]
[1,0,1]


Example 2

Input:
nums = [0,0,0,0]
goal = 0

Output:
10
(All subarrays)


Why Binary Array Matters

Since elements are only 0 or 1:

• Prefix Sum works
• Sliding Window (at most sum) works


1. BRUTE FORCE
Try every subarray and compute sum.
Time: O(n²)
*/

import java.util.*;

class Solution {

    public int numSubarraysWithSumBrute(int[] nums, int goal) {
        int ans = 0;

        for(int i = 0; i < nums.length; i++){
            int sum = 0;

            for(int j = i; j < nums.length; j++){
                sum += nums[j];

                if(sum == goal){
                    ans++;
                }
            }
        }

        return ans;
    }


/*
2. PREFIX SUM + HASHMAP

Core Idea:
If current prefix sum = sum

Need previous prefix:
sum - goal

Then subarray between them = goal


Time: O(n)
Space: O(n)

Best universal method
(works for negatives too)
*/

    public int numSubarraysWithSumPrefix(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();

        // prefix sum 0 seen once
        map.put(0, 1);

        int sum = 0;
        int ans = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            // need previous prefix = sum-goal
            if(map.containsKey(sum - goal)){
                ans += map.get(sum - goal);
            }

            // store current prefix
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }


/*
3. SLIDING WINDOW (ONLY FOR BINARY ARRAY)
Exactly(goal) = AtMost(goal) - AtMost(goal-1)

Why?
Subarrays with sum exactly 2 = subarrays with sum <=2 - subarrays with sum <=1

Time: O(n)
Space: O(1)

Best for binary arrays only.
*/

    public int numSubarraysWithSum(int[] nums, int goal) {
        int lessThanEqualsToGoal = countSubarrays(nums, goal);
        int lessThanEqualsToGoalMinus1 = countSubarrays(nums, goal - 1);

        return lessThanEqualsToGoal - lessThanEqualsToGoalMinus1;
    }

    // count subarrays with sum <= goal
    public int countSubarrays(int nums[], int goal){
        if(goal < 0) return 0;

        int n = nums.length;

        int left = 0;
        int right = 0;

        int sum = 0;
        int count = 0;

        while(right < n){
            sum += nums[right];

            // shrink if invalid
            while(sum > goal){
                sum -= nums[left];
                left++;
            }

            /*
                all windows ending at right
                from left...right are valid
            */
            count += (right - left + 1);
            right++;
        }

        return count;
    }
}
