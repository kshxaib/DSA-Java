import java.util.*;

class Solution1 {
    public int frogJump(int[] heights) {
        int n = heights.length;

        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n - 1, dp, heights);
    }

    private int solve(int i, int dp[], int heights[]) {
        if (i == 0) return 0;   // reached first stair

        if (dp[i] != -1) return dp[i];  // already computed

        int jumpTwo = Integer.MAX_VALUE;
        // jump from previous stair
        int jumpOne = solve(i - 1, dp, heights) + Math.abs(heights[i] - heights[i - 1]);

        if (i > 1) {    // jump from second previous stair
            jumpTwo = solve(i - 2, dp, heights) + Math.abs(heights[i] - heights[i - 2]);
        }

        return dp[i] = Math.min(jumpOne, jumpTwo);  // store minimum energy
    }
}

class Solution2 {
    public int frogJump(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int n = heights.length;
        int dp[] = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int jumpOne = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);    // jump from previous stair

            int jumpTwo = Integer.MAX_VALUE;

            if (i > 1) {    // jump from second previous stair
                jumpTwo = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }

            dp[i] = Math.min(jumpOne, jumpTwo); // jump from second previous stair
        }

        return dp[n - 1];
    }
}

class Solution {
    public int frogJump(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int n = heights.length;
        int prev = 0;   // dp[i-1]
        int prev2 = 0;  // dp[i-2]

        for (int i = 1; i < n; i++) {
            int jumpTwo = Integer.MAX_VALUE;

            int jumpOne = prev + Math.abs(heights[i] - heights[i - 1]);

            if (i > 1) {
                jumpTwo = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }

            int curr = Math.min(jumpOne, jumpTwo);

            // shift window
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}