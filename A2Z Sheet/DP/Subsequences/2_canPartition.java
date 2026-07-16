import java.util.*;

class Solution1 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i=0; i<nums.length; i++){
            sum += nums[i];
        }

        // Odd sum can't be divided equally
        if (sum % 2 != 0) return false;

        int target = sum / 2;

        int[][] dp = new int[n][target + 1];

        for (int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(n - 1, target, nums, dp);
    }

    private boolean solve(int index, int target, int[] nums, int[][] dp) {
        if (target == 0) return true;
        if (index == 0) return nums[0] == target;

        if (dp[index][target] != -1) return dp[index][target] == 1;

        boolean notTake = solve(index - 1, target, nums, dp);

        boolean take = false;
        if (nums[index] <= target){
            take = solve(index - 1, target - nums[index], nums, dp);
        }

        dp[index][target] = (take || notTake) ? 1 : 0;

        return take || notTake;
    }
}


class Solution2 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i=0; i<nums.length; i++){
            sum += nums[i];
        }

        // Odd sum can't be divided equally
        if (sum % 2 != 0) return false;

        int target = sum / 2;

        boolean[][] dp = new boolean[n][target + 1];

        // Sum 0 is always possible
        for (int i = 0; i < n; i++){
            dp[i][0] = true;
        }

        // First element
        if (nums[0] <= target){
            dp[0][nums[0]] = true;
        }

        for (int index = 1; index < n; index++) {
            for (int currTarget = 1; currTarget <= target; currTarget++) {

                boolean notTake = dp[index - 1][currTarget];

                boolean take = false;
                if (nums[index] <= currTarget){
                    take = dp[index - 1][currTarget - nums[index]];
                }

                dp[index][currTarget] = take || notTake;
            }
        }

        return dp[n - 1][target];
    }
}


class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i=0; i<nums.length; i++){
            sum += nums[i];
        }

        // Odd sum can't be divided equally
        if (sum % 2 != 0) return false;

        int target = sum / 2;

        boolean[] prev = new boolean[target + 1];
        prev[0] = true;

        if (nums[0] <= target){
            prev[nums[0]] = true;
        }

        for (int index = 1; index < n; index++) {
            boolean[] curr = new boolean[target + 1];
            curr[0] = true;

            for (int currTarget = 1; currTarget <= target; currTarget++) {
                boolean notTake = prev[currTarget];

                boolean take = false;
                if (nums[index] <= currTarget){
                    take = prev[currTarget - nums[index]];
                }

                curr[currTarget] = take || notTake;
            }

            prev = curr;
        }

        return prev[target];
    }
}