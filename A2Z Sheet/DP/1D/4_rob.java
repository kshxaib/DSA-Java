import java.util.*;

class Solution1 {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        return solve(n-1, nums, dp);
    }

    private int solve(int i, int nums[], int dp[]){
        if(i == 0) return nums[0];  // first house
        if(i < 0) return 0; // no house left

        if(dp[i] != -1) return dp[i];   // already computed

        int pick = nums[i] + solve(i-2, nums, dp);  // rob current house
        int notPick = solve(i-1, nums, dp); // skip current house

        return dp[i] = Math.max(pick, notPick); // store maximum profit
    }
}


class Solution2 {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int dp[] = new int[n];
        dp[0] = nums[0];

        for(int i=1; i<n; i++){  // build answers
            int pick = nums[i];  // rob current house

            if(i-2>=0){
                pick += dp[i-2];
            }

            int notPick = dp[i - 1];    // skip current house

            dp[i] = Math.max(pick, notPick);    // maximum profit
        }

        return dp[n-1];
    }
}


class Solution3 {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int prev2 = 0;  // dp[i-2]
        int prev1 = nums[0];    // dp[i-1]

        for(int i=1; i<n; i++){     // build answers
            int pick = prev2 + nums[i]; // rob current house
            int notPick = prev1;    // skip current house

            int curr = Math.max(pick, notPick);
            // shift window
            prev2 = prev1;
            prev1 = curr;            
        }

        return prev1;
    }
}