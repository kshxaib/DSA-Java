import java.util.*;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        int[] count = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int maxLength = 1;

        for (int index = 0; index < n; index++) {
            for (int prevIndex = 0; prevIndex < index; prevIndex++) {

                if (nums[index] > nums[prevIndex]) {

                    if (dp[prevIndex] + 1 > dp[index]) {
                        dp[index] = dp[prevIndex] + 1;
                        count[index] = count[prevIndex];
                    }

                    else if (dp[prevIndex] + 1 == dp[index]) {
                        count[index] += count[prevIndex];
                    }
                }
            }

            maxLength = Math.max(maxLength, dp[index]);
        }

        int totalCount = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLength) {
                totalCount += count[i];
            }
        }

        return totalCount;
    }
}