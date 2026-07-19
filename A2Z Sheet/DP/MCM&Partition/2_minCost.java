import java.util.*;

class Solution1 {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;

        int[] arr = new int[m + 2]; // add boundaries

        arr[0] = 0;
        arr[m + 1] = n;

        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }

        Arrays.sort(arr);   // sort cut positions

        int[][] dp = new int[m + 2][m + 2]; // dp[i][j] = minimum cost for cuts i...j

        for (int i = 0; i < m + 2; i++) {
            Arrays.fill(dp[i], -1);
        }
    
        return solve(1, m, arr, dp);
    }   

    private int solve(int i, int j, int[] arr, int[][] dp) {
        if (i > j) return 0;    // no cuts remaining

        if (dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j; k++) {  // try every cut first

            int left = solve(i, k - 1, arr, dp);    // cost of left interval
            int right = solve(k + 1, j, arr, dp);   // cost of right interval
            int cost = arr[j + 1] - arr[i - 1];     // current stick length

            ans = Math.min(ans, cost + left + right);   // keep minimum
        }

        return dp[i][j] = ans;
    }
}




class Solution2 {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;

        int[] newCuts = new int[m + 2];

        newCuts[0] = 0;
        newCuts[m + 1] = n;

        for (int i = 0; i < m; i++){
            newCuts[i + 1] = cuts[i];
        }

        Arrays.sort(newCuts);

        int[][] dp = new int[m + 2][m + 2];

        for (int i = m; i >= 1; i--) {
            for (int j = i; j <= m; j++) {

                int minCost = Integer.MAX_VALUE;

                for (int k = i; k <= j; k++) {
                    int cost = (newCuts[j + 1] - newCuts[i - 1]) + dp[i][k - 1] + dp[k + 1][j];
                    minCost = Math.min(minCost, cost);
                }

                dp[i][j] = minCost;
            }
        }

        return dp[1][m];
    }
}