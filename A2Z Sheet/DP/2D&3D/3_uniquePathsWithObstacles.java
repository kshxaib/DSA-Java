import java.util.*;

class Solution1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int dp[][] = new int[m][n];

        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(m-1, n-1, obstacleGrid, dp);
    }

    private int solve(int row, int col, int obstacleGrid[][], int dp[][]){
        if(row < 0 || col < 0) return 0;
        if(obstacleGrid[row][col] == 1) return 0;
        if(row == 0 && col == 0) return 1;

        if (dp[row][col] != -1) return dp[row][col];

        int up = solve(row-1, col, obstacleGrid, dp); 
        int left = solve(row, col-1, obstacleGrid, dp); 

        return dp[row][col] = up + left;
    }
}


class Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {

                // Obstacle
                if (obstacleGrid[row][col] == 1) {
                    dp[row][col] = 0;
                    continue;
                }

                // Starting cell
                if (row == 0 && col == 0) {
                    dp[row][col] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                if (row > 0) up = dp[row - 1][col];

                if (col > 0) left = dp[row][col - 1];
                dp[row][col] = up + left;
            }
        }

        return dp[m - 1][n - 1];
    }
}


class Solution3 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] prev = new int[n];

        for (int row = 0; row < m; row++) {
            int[] curr = new int[n];

            for (int col = 0; col < n; col++) {
                // Obstacle
                if (obstacleGrid[row][col] == 1) {
                    curr[col] = 0;
                    continue;
                }

                // Starting cell
                if (row == 0 && col == 0) {
                    curr[col] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                if (row > 0) up = prev[col];

                if (col > 0) left = curr[col - 1];
                curr[col] = up + left;
            }

            prev = curr;
        }

        return prev[n - 1];
    }
}