import java.util.*;

class Solution1 {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n + 2]; // add virtual balloons

        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2]; // dp[i][j] = maximum coins from i...j

        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(1, n, arr, dp);
    }

    private int solve(int i, int j, int[] arr, int[][] dp) {
        if (i > j) return 0;    // no balloons left

        if (dp[i][j] != -1) return dp[i][j];    

        int maxCoins = 0;

        // try every balloon as last
        for (int k = i; k <= j; k++) {

            int left = solve(i, k - 1, arr, dp);    // left interval            
            int right = solve(k + 1, j, arr, dp);   // right interval
            int currentCoins = arr[i - 1] * arr[k] * arr[j + 1];    // coins from last balloon
            int totalCoins = left + right + currentCoins;

            maxCoins = Math.max(maxCoins, totalCoins);  // keep maximum
        }

        return dp[i][j] = maxCoins;
    }
}




class Solution2 {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n + 2];

        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {

                int maxCoins = 0;

                for (int k = i; k <= j; k++) {
                    int coins = dp[i][k - 1] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j + 1];
                    maxCoins = Math.max(maxCoins, coins);
                }

                dp[i][j] = maxCoins;
            }
        }

        return dp[1][n];
    }
}