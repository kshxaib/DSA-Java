import java.util.*;

class Solution1 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, -1, nums, dp);
    }

    private int solve(int index, int prevIndex, int[] nums, int[][] dp) {
        if (index == nums.length) return 0;

        if (dp[index][prevIndex + 1] != -1) return dp[index][prevIndex + 1];

        int notTake = solve(index + 1, prevIndex, nums, dp);

        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + solve(index + 1, index, nums, dp);
        }

        return dp[index][prevIndex + 1] = Math.max(take, notTake);
    }
}



class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n + 1][n + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int prevIndex = index - 1; prevIndex >= -1; prevIndex--) {

                int notTake = dp[index + 1][prevIndex + 1];

                int take = 0;
                if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
                    take = 1 + dp[index + 1][index + 1];
                }

                dp[index][prevIndex + 1] = Math.max(take, notTake);
            }
        }

        return dp[0][0];
    }
}


class Solution3 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] ahead = new int[n + 1];

        for (int index = n - 1; index >= 0; index--) {
            int[] curr = new int[n + 1];

            for (int prevIndex = index - 1; prevIndex >= -1; prevIndex--) {

                int notTake = ahead[prevIndex + 1];

                int take = 0;
                if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
                    take = 1 + ahead[index + 1];
                }

                curr[prevIndex + 1] = Math.max(take, notTake);
            }

            ahead = curr;
        }

        return ahead[0];
    }
}



class Solution4 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        int maxLength = 1;

        for (int index = 0; index < n; index++) {
            for (int prevIndex = 0; prevIndex < index; prevIndex++) {

                if (nums[index] > nums[prevIndex]) {
                    dp[index] = Math.max(dp[index], 1 + dp[prevIndex]);
                }
            }

            maxLength = Math.max(maxLength, dp[index]);
        }

        return maxLength;
    }
}