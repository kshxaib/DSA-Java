import java.util.*;

class Solution1 {
    static final int MOD = 1000000007;

    public int countPartitions(int[] arr, int diff) {
        int n = arr.length;

        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        if (totalSum - diff < 0 || (totalSum - diff) % 2 != 0) return 0;

        int target = (totalSum - diff) / 2;

        int[][] dp = new int[n][target + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(n - 1, target, arr, dp);
    }

    private int solve(int index, int target, int[] arr, int[][] dp) {

        if (index == 0) {
            if (target == 0 && arr[0] == 0) return 2;
            if (target == 0 || arr[0] == target) return 1;
            return 0;
        }

        if (dp[index][target] != -1)
            return dp[index][target];

        int notTake = solve(index - 1, target, arr, dp);

        int take = 0;
        if (arr[index] <= target) {
            take = solve(index - 1, target - arr[index], arr, dp);
        }

        return dp[index][target] = (take + notTake) % MOD;
    }
}



class Solution2 {
    static final int MOD = 1000000007;

    public int countPartitions(int[] arr, int diff) {
        int n = arr.length;

        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        if (totalSum - diff < 0 || (totalSum - diff) % 2 != 0) return 0;

        int target = (totalSum - diff) / 2;

        int[][] dp = new int[n][target + 1];

        // Base case
        if (arr[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;

        if (arr[0] != 0 && arr[0] <= target) dp[0][arr[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int sum = 0; sum <= target; sum++) {

                int notTake = dp[i - 1][sum];

                int take = 0;
                if (arr[i] <= sum) {
                    take = dp[i - 1][sum - arr[i]];
                }

                dp[i][sum] = (notTake + take) % MOD;
            }
        }

        return dp[n - 1][target];
    }
}


