public class CountBSTs {

    /*
      Count Unique BSTs (Catalan Number)

      Meaning:
      - Count how many unique BSTs can be formed using n nodes
        (values 1 to n)

      This is based on Catalan numbers:
      dp[n] = number of unique BSTs with n nodes

      Logic:
      - Choose each node as root (j)
      - Left subtree gets j nodes
      - Right subtree gets (n-j-1) nodes
      - total BSTs for this root = leftWays * rightWays
      - sum for all roots
    */
    public static int CB(int n) {

        // dp[i] = number of unique BSTs using i nodes
        int dp[] = new int[n + 1];

        // Base cases:
        // 0 nodes -> 1 BST (empty tree)
        // 1 node  -> 1 BST
        dp[0] = 1;
        dp[1] = 1;

        // Build dp from 2 to n
        for (int i = 2; i < n + 1; i++) {

            // Try every possible root position
            for (int j = 0; j < i; j++) {

                // left subtree nodes = j
                int left = dp[j];

                // right subtree nodes = (i-j-1)
                int right = dp[i - j - 1];

                // Total BSTs with this root = leftWays * rightWays
                dp[i] += left * right;
            }
        }

        // Final answer = number of unique BSTs with n nodes
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;

        // For n=4, answer = 14
        System.out.println(CB(n));
    }
}

/*
Time Complexity:
- O(n^2)
  because for each i (1..n), we loop j (0..i-1)

Space Complexity:
- O(n)
  dp array of size n+1
*/
