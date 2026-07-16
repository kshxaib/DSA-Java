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


