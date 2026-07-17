import java.util.*;

class Solution1 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(n - 1, m - 1, s, p, dp);
    }

    private boolean solve(int i, int j, String s, String p, int[][] dp) {
        if (i < 0 && j < 0) return true;

        if (j < 0) return false;

        if (i < 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*')
                    return false;
            }
            return true;
        }

        if (dp[i][j] != -1) return dp[i][j] == 1;

        boolean ans;

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            ans = solve(i - 1, j - 1, s, p, dp);

        } else if (p.charAt(j) == '*') {
            ans = solve(i - 1, j, s, p, dp) || solve(i, j - 1, s, p, dp);

        } else {
            ans = false;
        }

        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
}


class Solution2 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        for (int j = 1; j <= m; j++) {
            boolean flag = true;

            for (int k = 1; k <= j; k++) {

                if (p.charAt(k - 1) != '*') {
                    flag = false;
                    break;
                }
            }

            dp[0][j] = flag;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];

                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];

                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }
}


