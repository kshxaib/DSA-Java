import java.util.*;

class Solution1 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int lcs = solve(n - 1, m - 1, word1, word2, dp);

        return (n - lcs) + (m - lcs);
    }

    private int solve(int i, int j, String word1, String word2, int[][] dp) {
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = 1 + solve(i - 1, j - 1, word1, word2, dp);
        }

        return dp[i][j] = Math.max(solve(i-1, j, word1, word2, dp), solve(i, j-1, word1, word2, dp));
    }
}




class Solution2 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcs = dp[n][m];

        return (n - lcs) + (m - lcs);
    }
}




class Solution3 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] prev = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];

            for (int j = 1; j <= m; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }

            prev = curr;
        }

        int lcs = prev[m];

        return (n - lcs) + (m - lcs);
    }
}