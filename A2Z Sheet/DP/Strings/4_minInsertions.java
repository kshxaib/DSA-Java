import java.util.*;

class Solution1 {
    public int minInsertions(String s) {
        String rev = new StringBuilder(s).reverse().toString();

        int n = s.length();

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int lps = solve(n - 1, n - 1, s, rev, dp);

        return n - lps;
    }

    private int solve(int i, int j, String s, String rev, int[][] dp) {
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == rev.charAt(j)) {
            return dp[i][j] = 1 + solve(i - 1, j - 1, s, rev, dp);
        }

        return dp[i][j] = Math.max(solve(i-1, j, s, rev, dp), solve(i, j-1, s, rev, dp));
    }
}