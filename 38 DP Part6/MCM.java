import java.util.Arrays;

public class MCM {

    /*
      Matrix Chain Multiplication (MCM)

      arr[] represents matrix dimensions:
      A1 = arr[0] x arr[1]
      A2 = arr[1] x arr[2]
      ...
      A(n-1) = arr[n-2] x arr[n-1]

      Goal:
      - Find minimum multiplication cost to multiply A1...A(n-1)
    */

    // 1) Recursive MCM
    public static int mcm(int arr[], int i, int j) {

        // Base case: single matrix => no multiplication cost
        if (i == j) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;

        // Try all partitions
        for (int k = i; k < j; k++) {

            int cost1 = mcm(arr, i, k);       // left part
            int cost2 = mcm(arr, k + 1, j);   // right part

            // cost of multiplying two resulting matrices
            int cost3 = arr[i - 1] * arr[k] * arr[j];

            int finalCost = cost1 + cost2 + cost3;

            minCost = Math.min(minCost, finalCost);
        }

        return minCost;
    }

    // 2) Memoization MCM (Top-Down DP)
    public static int mcmM(int arr[], int i, int j, int dp[][]) {

        // Base case
        if (i == j) {
            return 0;
        }

        // If already computed, return stored result
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int minCost = Integer.MAX_VALUE;

        // Try all partitions
        for (int k = i; k < j; k++) {

            int cost1 = mcmM(arr, i, k, dp);
            int cost2 = mcmM(arr, k + 1, j, dp);

            int cost3 = arr[i - 1] * arr[k] * arr[j];

            int finalCost = cost1 + cost2 + cost3;

            minCost = Math.min(minCost, finalCost);
        }

        // Store answer
        return dp[i][j] = minCost;
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 3 };
        int n = arr.length;

        System.out.println(mcm(arr, 1, n - 1)); // 30

        int dp[][] = new int[n][n];

        // Initialize dp with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(mcmM(arr, 1, n - 1, dp)); // 30
    }
}

/*
Complexities:

1) Recursive MCM:
Time Complexity: Exponential
Space Complexity: O(n) recursion stack

2) Memoization MCM:
Time Complexity: O(n^3)
Space Complexity: O(n^2) dp + O(n) recursion stack
*/
