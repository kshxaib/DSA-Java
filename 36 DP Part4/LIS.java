import java.util.Arrays;
import java.util.HashSet;

public class LIS {

    /*
      LCS for Integer Arrays (Tabulation)

      dp[i][j] means:
      - LCS length between:
        arr[0 ... i-1] and arr2[0 ... j-1]
    */
    public static int lcs(int arr[], int arr2[]) {

        int n = arr.length;
        int m = arr2.length;

        // dp table: (n+1) x (m+1)
        int dp[][] = new int[n + 1][m + 1];

        // Base case:
        // If any array is empty => LCS = 0
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = 0;
        }

        // Fill dp table
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                // If elements match, include it in LCS
                if (arr[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {
                    // If not match, take max by skipping one element
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        // Final LCS length
        return dp[n][m];
    }

    /*
      LIS using LCS Concept

      Steps:
      1) Create a sorted unique array arr2 from arr
      2) LIS(arr) = LCS(arr, arr2)

      Reason:
      - arr2 is sorted (increasing)
      - LCS ensures order is preserved in original arr
      - So common sequence becomes an increasing subsequence
    */
    public static int lis(int arr[]) {

        // Step 1: Remove duplicates using HashSet
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        // Step 2: Convert set to array
        int arr2[] = new int[set.size()];
        int i = 0;
        for (int num : set) {
            arr2[i] = num;
            i++;
        }

        // Step 3: Sort arr2 (increasing order)
        Arrays.sort(arr2);

        // Step 4: Find LCS between original and sorted unique array
        return lcs(arr, arr2);
    }

    public static void main(String[] args) {

        int arr[] = { 50, 3, 10, 7, 40, 80 };

        System.out.println(lis(arr)); // Output: 4 (3, 7, 40, 80)
    }
}

/*
Time Complexity:
1) Creating set: O(n)
2) Sorting arr2: O(k log k) where k = number of unique elements
3) LCS DP: O(n * k)

Overall Time Complexity: O(n * k)

Space Complexity:
- dp table size = O(n * k)
- extra array + set = O(k)

Overall Space Complexity: O(n * k)
*/
