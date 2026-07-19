import java.util.*;

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;

        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return solve(0, arr, k, dp);
    }

    private int solve(int index, int[] arr, int k, int[] dp) {
        if (index == arr.length) return 0;

        if (dp[index] != -1) return dp[index];

        int maxSum = 0;
        int currentMax = 0;
        int length = 0;

        for (int j = index; j < Math.min(arr.length, index + k); j++) {
            length++;
            currentMax = Math.max(currentMax, arr[j]);
            int sum = length * currentMax + solve(j + 1, arr, k, dp);
            maxSum = Math.max(maxSum, sum);
        }

        return dp[index] = maxSum;
    }
}