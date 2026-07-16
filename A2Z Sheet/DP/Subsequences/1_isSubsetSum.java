import java.util.*;

class Solution {
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


