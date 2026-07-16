import java.util.*;

class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int dp[][] = new int[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 0, triangle, dp);
    }

    private int solve(int row, int col, List<List<Integer>> triangle, int dp[][]){
        if(row == triangle.size() -1){
            return triangle.get(row).get(col);
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        // Move down
        int down = triangle.get(row).get(col) + solve(row + 1, col, triangle, dp);
        // Move diagonal
        int diagonal = triangle.get(row).get(col) + solve(row + 1, col + 1, triangle, dp);

        return dp[row][col] = Math.min(down, diagonal);
    }
}



class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int dp[][] = new int[n][n];

        // Base Case: Copy last row
        for (int col = 0; col < n; col++) {
            dp[n - 1][col] = triangle.get(n - 1).get(col);
        }

        // Build from bottom to top
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {

                int down = triangle.get(row).get(col) + dp[row + 1][col];
                int diagonal = triangle.get(row).get(col) + dp[row + 1][col + 1];
                dp[row][col] = Math.min(down, diagonal);
            }
        }

        return dp[0][0];
    }
}


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        // Previous row = last row initially
        int[] prev = new int[n];

        for (int col = 0; col < n; col++) {
            prev[col] = triangle.get(n - 1).get(col);
        }

        // Process from bottom to top
        for (int row = n - 2; row >= 0; row--) {
            int[] curr = new int[n];

            for (int col = 0; col <= row; col++) {
                int down = triangle.get(row).get(col) + prev[col];
                int diagonal = triangle.get(row).get(col) + prev[col + 1];
                curr[col] = Math.min(down, diagonal);
            }

            prev = curr;
        }

        return prev[0];
    }
}