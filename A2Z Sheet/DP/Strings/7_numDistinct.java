import java.util.*;

class Solution1 {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(n - 1, m - 1, s, t, dp);
    }

    private int solve(int i, int j, String s, String t, int[][] dp) {
        if (j < 0) return 1;
        if (i < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            int take = solve(i - 1, j - 1, s, t, dp);
            int notTake = solve(i - 1, j, s, t, dp);
            
            return dp[i][j] = take + notTake;
        }

        return dp[i][j] = solve(i - 1, j, s, t, dp);
    }
}