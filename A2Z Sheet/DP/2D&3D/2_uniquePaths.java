import java.util.*;

class Solution1 {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];

        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(m-1, n-1, dp);
    }

    private int solve(int row, int col, int dp[][]){
        if(row == 0 && col == 0) return 1;
        if(row < 0 || col < 0) return 0;

        if(dp[row][col] != -1) return dp[row][col];

        int up = solve(row-1, col, dp);
        int left = solve(row, col-1, dp);

        return dp[row][col] = up + left;
    }
}


class Solution2 {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];

        dp[0][0] = 1;

        for(int row=0; row<m; row++){
            for(int col=0; col<n; col++){
                if(row == 0 && col == 0) continue;

                int up = 0;
                int left = 0; 

                if(row > 0){
                    up = dp[row -1][col];
                }

                if(col > 0){
                    left = dp[row][col -1];
                }

                dp[row][col] = up + left;
            }
        }

        return dp[m-1][n-1];
    }
}


class Solution {
    public int uniquePaths(int m, int n) {
        int prevRow[] = new int[n];

        for(int row=0; row<m; row++){
            int currRow[] = new int[n];

            for(int col=0; col<n; col++){

                if(row == 0 && col == 0){
                    currRow[col] = 1;
                    continue;
                }

                int up = 0;
                int left = 0; 

                if(row > 0){
                    up = prevRow[col];
                }

                if(col > 0){
                    left = currRow[col -1];
                }

                currRow[col] = up + left;
            }

            prevRow = currRow;
        }

        return prevRow[n-1];
    }
}