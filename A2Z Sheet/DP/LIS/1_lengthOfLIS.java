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

        int[] dp = new int[n];  // dp[i] = LIS ending at i

        Arrays.fill(dp, 1); // every element itself forms LIS of length 1

        int maxLength = 1;

        // compute LIS ending at every index
        for (int index = 0; index < n; index++) {
            for (int prevIndex = 0; prevIndex < index; prevIndex++) {

                // can extend previous LIS
                if (nums[index] > nums[prevIndex]) {
                    dp[index] = Math.max(dp[index], 1 + dp[prevIndex]);
                }
            }

            maxLength = Math.max(maxLength, dp[index]); // update overall answer
        }

        return maxLength;
    }
}


class Solution5 {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();    // stores smallest possible tail

        for (int num : nums) {
            if (list.isEmpty() || num > list.get(list.size() - 1)) {    // extend LIS
                list.add(num);

            } else {    // replace first element >= num
                int index = lowerBound(list, num);
                list.set(index, num);
            }
        }

        return list.size(); // size of list = LIS length
    }

    // first index whose value >= target
    private int lowerBound(ArrayList<Integer> list, int target) {
        int firstGreaterOrEqualIdx = -1;
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (list.get(mid) >= target) {
                firstGreaterOrEqualIdx = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return firstGreaterOrEqualIdx;
    }
}