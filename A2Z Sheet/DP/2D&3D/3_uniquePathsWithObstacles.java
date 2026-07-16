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
        if(row < 0 || col < 0) return 0;    // outside grid
        if(obstacleGrid[row][col] == 1) return 0;   // obstacle
        if(row == 0 && col == 0) return 1;  // reached start

        if (dp[row][col] != -1) return dp[row][col];    // already computed

        int up = solve(row-1, col, obstacleGrid, dp);   // move from top
        int left = solve(row, col-1, obstacleGrid, dp);     // move from left

        return dp[row][col] = up + left;    // store answer
    }
}


class Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {

                if (obstacleGrid[row][col] == 1) {  // Obstacle
                    dp[row][col] = 0;
                    continue;
                }
               
                if (row == 0 && col == 0) {      // Starting cell
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
                if (obstacleGrid[row][col] == 1) {  // Obstacle
                    curr[col] = 0;
                    continue;
                }

                if (row == 0 && col == 0) {     // Starting cell
                    curr[col] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                if (row > 0) up = prev[col];     // top cell
                if (col > 0) left = curr[col - 1];  // left cell
                curr[col] = up + left;  // total paths
            }

            prev = curr;    // move current row
        }

        return prev[n - 1];
    }
}