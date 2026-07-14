import java.util.*;

class Solution1 {
    public int frogJump(int[] heights, int k) {
        int n = heights.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        
        return solve(n - 1, heights, dp, k);
    }

    private int solve(int i, int heights[], int dp[], int k){
        if(i == 0) return 0;     // reached first stair

        if(dp[i] != -1) return dp[i];   // already computed

        int minEnergy = Integer.MAX_VALUE;
        for(int j=1; j<=k; j++){    // try every possible jump
            if(i-j >= 0){
                int jump = solve(i-j, heights, dp, k) + Math.abs(heights[i] - heights[i-j]);
                minEnergy = Math.min(minEnergy, jump);
            }
        }

        return dp[i] = minEnergy;   // store answer
    }
}

class Solution2 {
    public int frogJump(int[] heights, int k) {
        int n = heights.length;
        int dp[] = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i=1; i<n; i++){ // build answers
            int minEnergy = Integer.MAX_VALUE;
            for(int j=1; j<=k; j++){    // try every possible jump
                if(i-j >=0){
                    int jump = dp[i-j] + Math.abs(heights[i] - heights[i-j]);
                    minEnergy = Math.min(minEnergy, jump);
                }
            }

            dp[i] = minEnergy;  // minimum energy to reach current stair
        }

        return dp[n-1];
    }
}