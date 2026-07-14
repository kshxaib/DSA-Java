import java.util.*;

class Solution1 {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int case1 = solve(nums, 0, n - 2, dp1);
        int case2 = solve(nums, 1, n - 1, dp2);

        return Math.max(case1, case2);
    }

    private int solve(int[] nums, int start, int end, int[] dp) {
        if (start > end) return 0;

        if (dp[end] != -1) return dp[end];

        int pick = nums[end] + solve(nums, start, end -2, dp);
        int notPick = solve(nums, start, end -1, dp);

        return dp[end] = Math.max(pick, notPick);
    }
}


class Solution2 {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int case1 = solve(nums, 0, n - 2);
        int case2 = solve(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    private int solve(int[] nums, int start, int end) {
        int n = end - start +1;
        int dp[] = new int[n];
        dp[0] = nums[start];

        for(int i=1; i<n; i++){
            int pick = nums[start + i];

            if(i-2>=0){
                pick += dp[i-2];
            }

            int notPick = dp[i-1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[n-1];
    }
}


class Solution3 {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int case1 = solve(nums, 0, n - 2);
        int case2 = solve(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    private int solve(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev1;

            int curr = Math.max(pick, notPick);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}