import java.util.*;

class Solution1 {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum - target < 0 || (totalSum - target) % 2 != 0) return 0;

        int sum = (totalSum - target) / 2;

        int[][] dp = new int[n][sum + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(n - 1, sum, nums, dp);
    }

    private int solve(int index, int target, int[] nums, int[][] dp) {
        if (index == 0) {
            if (target == 0 && nums[0] == 0) return 2;
            if (target == 0 || nums[0] == target) return 1;
            return 0;
        }

        if (dp[index][target] != -1) return dp[index][target];

        int notTake = solve(index - 1, target, nums, dp);

        int take = 0;
        if (nums[index] <= target) {
            take = solve(index - 1, target - nums[index], nums, dp);
        }

        return dp[index][target] = take + notTake;
    }
}



class Solution2 {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum - target < 0 || (totalSum - target) % 2 != 0) return 0;

        int sum = (totalSum - target) / 2;

        int[][] dp = new int[n][sum + 1];

        // Base case
        if (nums[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;

        if (nums[0] != 0 && nums[0] <= sum) dp[0][nums[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int s = 0; s <= sum; s++) {
                int notTake = dp[i - 1][s];

                int take = 0;
                if (nums[i] <= s) {
                    take = dp[i - 1][s - nums[i]];
                }

                dp[i][s] = take + notTake;
            }
        }

        return dp[n - 1][sum];
    }
}



class Solution3 {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum - target < 0 || (totalSum - target) % 2 != 0) return 0;

        int sum = (totalSum - target) / 2;

        int[] prev = new int[sum + 1];

        // Base case
        if (nums[0] == 0) prev[0] = 2;
        else prev[0] = 1;

        if (nums[0] != 0 && nums[0] <= sum) prev[nums[0]] = 1;

        for (int i = 1; i < n; i++) {
            int[] curr = new int[sum + 1];

            for (int s = 0; s <= sum; s++) {
                int notTake = prev[s];

                int take = 0;
                if (nums[i] <= s) {
                    take = prev[s - nums[i]];
                }

                curr[s] = take + notTake;
            }

            prev = curr;
        }

        return prev[sum];
    }
}