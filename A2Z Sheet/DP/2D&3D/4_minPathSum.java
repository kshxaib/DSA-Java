import java.util.*;

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(m - 1, n - 1, grid, dp);
    }

    private int solve(int row, int col, int[][] grid, int[][] dp) {
        if (row == 0 && col == 0) return grid[0][0];    // Starting cell

        if (row < 0 || col < 0) return Integer.MAX_VALUE;   // Out of bounds

        if (dp[row][col] != -1) return dp[row][col];

        int up = solve(row - 1, col, grid, dp);
        int left = solve(row, col - 1, grid, dp);

        return dp[row][col] = grid[row][col] + Math.min(up, left);
    }
}


class Solution2 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {

                if (row == 0 && col == 0) {     // Starting cell
                    dp[row][col] = grid[row][col];
                    continue;
                }

                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;

                if (row > 0) up = dp[row - 1][col];
                if (col > 0) left = dp[row][col - 1];
                dp[row][col] = grid[row][col] + Math.min(up, left);
            }
        }

        return dp[m - 1][n - 1];
    }
}


class Solution3 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] prev = new int[n];

        for (int row = 0; row < m; row++) {
            int[] curr = new int[n];

            for (int col = 0; col < n; col++) {
                if (row == 0 && col == 0) {     // Starting cell
                    curr[col] = grid[row][col];
                    continue;
                }

                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;

                if (row > 0) up = prev[col];
                if (col > 0) left = curr[col - 1];
                curr[col] = grid[row][col] + Math.min(up, left);
            }

            prev = curr;
        }

        return prev[n - 1];
    }
}