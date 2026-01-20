import java.util.*;

public class TargetSumSubset {

    /*
      Target Sum Subset (Recursive)
      Meaning:
      - Given an array, check if there exists a subset whose sum = target

      Recursive Idea:
      - For every element, we have 2 choices:
        1) Include it in subset
        2) Exclude it from subset
      - If at any point sum becomes target, return true
    */
    public static boolean TSS(int nums[], int sum, int tot, int i) {

        // Base case 1:
        // If current sum becomes exactly target, subset found
        if (tot == sum) {
            return true;
        }

        // Base case 2:
        // If we reached the end of array, no more elements left
        if (i == nums.length) {
            return false;
        }

        // Option 1: Include current element
        // We only include if it doesn't exceed target
        if (tot + nums[i] <= sum) {
            if (TSS(nums, sum, tot + nums[i], i + 1)) {
                return true;
            }
        }

        // Option 2: Exclude current element
        if (TSS(nums, sum, tot, i + 1)) {
            return true;
        }

        // If both include and exclude fail, subset not possible
        return false;
    }

    /*
      Target Sum Subset (Memoization / Top-Down DP)
      
      dp[i][tot] stores:
      - whether we can make target sum using elements from index i onwards
        when current sum is tot

      Values:
      dp[i][tot] = -1 -> not computed
      dp[i][tot] =  0 -> false
      dp[i][tot] =  1 -> true

      Why Memoization?
      - Recursive calls repeat the same states again and again
      - dp helps store computed states and avoids recomputation
    */
    public static boolean TSSM(int nums[], int sum, int tot, int i, int dp[][]) {

        // If we reach target sum
        if (tot == sum) {
            return true;
        }

        // If array ends
        if (i == nums.length) {
            return false;
        }

        // If state already solved, return stored answer
        if (dp[i][tot] != -1) {
            return dp[i][tot] == 1;
        }

        boolean ans = false;

        // Option 1: Include current element (if possible)
        if (tot + nums[i] <= sum) {
            ans = TSSM(nums, sum, tot + nums[i], i + 1, dp);
        }

        // Option 2: Exclude current element (if include didn't work)
        if (!ans) {
            ans = TSSM(nums, sum, tot, i + 1, dp);
        }

        // Store result in dp table
        dp[i][tot] = ans ? 1 : 0;

        return ans;
    }

    /*
      Target Sum Subset (Tabulation / Bottom-Up DP)

      dp[i][j] means:
      - using first i elements, can we form sum j?

      Transitions:
      - Exclude element -> dp[i-1][j]
      - Include element -> dp[i-1][j - value] (if value <= j)
    */
    public static boolean TSST(int nums[], int sum) {

        int n = nums.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];

        // Base case:
        // sum = 0 is always possible (empty subset)
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }

        // Fill the dp table
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {

                int v = nums[i - 1]; // current element

                // Option 1: Exclude current element
                if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }

                // Option 2: Include current element (if it fits)
                else if (v <= j && dp[i - 1][j - v] == true) {
                    dp[i][j] = true;
                }
            }
        }

        // Final answer
        return dp[n][sum];
    }

    public static void main(String[] args) {

        int nums[] = { 4, 2, 7, 1, 3 };
        int sum = 10;

        // Recursive Answer
        System.out.println(TSS(nums, sum, 0, 0));

        // Memoization Answer
        int dp[][] = new int[nums.length + 1][sum + 1];

        // Initialize dp with -1
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(TSSM(nums, sum, 0, 0, dp));

        // Tabulation Answer
        System.out.println(TSST(nums, sum));
    }
}

/*
1) Recursive Target Sum Subset:
Time Complexity : O(2^n)
Space Complexity : O(n) (recursion stack)

2) Memoization (Top-Down DP):
Time Complexity : O(n * sum)
Space Complexity : O(n * sum) dp + O(n) recursion stack

3) Tabulation (Bottom-Up DP):
Time Complexity : O(n * sum)
Space Complexity : O(n * sum)
*/
