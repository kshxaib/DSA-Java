class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i=0; i<nums.length; i++){
            sum += num[i];
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