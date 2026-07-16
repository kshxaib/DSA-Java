import java.util.*;

class Solution1 {
    public boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        int dp[][] = new int[n][target+1];

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(n-1, target, arr, dp);
    }

    private boolean solve(int i, int target, int arr[], int dp[][]){
        if(target == 0) return true;
        if(i == 0) return arr[0] == target;

        if(dp[i][target] != -1) return dp[i][target] == 1;

        boolean notTake = solve(i-1, target, arr, dp);

        boolean take = false;
        if(arr[i] <= target){
            take = solve(i-1, target - arr[i], arr, dp);
        }

        dp[i][target] = (take || notTake) == true ? 1 : 0;
        return (take || notTake);
    }
}


class Solution2 {
    public boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        boolean dp[][] = new boolean[n][target+1];

        // Sum 0 is always possible
        for (int i = 0; i < n; i++){
            dp[i][0] = true;
        }

        if(arr[0] <= target){
            dp[0][arr[0]] = true;
        }

        for(int i=1; i<n; i++){
            for(int sum =1; sum <= target; sum++){
                boolean notTake = dp[i - 1][sum];
                
                boolean take = false;
                if (arr[i] <= sum){
                    take = dp[i - 1][sum - arr[i]];
                }

                dp[i][sum] = take || notTake;
            }
        }

        return dp[n-1][target];
    }
}


