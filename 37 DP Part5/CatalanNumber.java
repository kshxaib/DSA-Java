public class CatalanNumber {

    /*
      Catalan Number (Recursive)

      Catalan numbers appear in many DP problems like:
      - Number of BSTs possible with n nodes
      - Number of valid parentheses combinations
      - Number of ways to triangulate polygon
      - Mountain ranges problems etc.

      Formula:
      C0 = 1
      C1 = 1

      Cn = Σ (Ci * C(n-i-1))
           for i = 0 to n-1

      Idea:
      - Choose i nodes in left subtree
      - Remaining (n-i-1) nodes in right subtree
      - Total ways = leftWays * rightWays
      - Add all possibilities
    */
    public static int CN(int n) {

        // Base case:
        // Catalan(0) = 1 and Catalan(1) = 1
        if (n == 0 || n == 1) {
            return 1;
        }

        // Store result for Catalan(n)
        int ans = 0;

        // Try all possible splits of nodes into left and right
        for (int i = 0; i < n; i++) {

            // Left subtree has i nodes  -> Catalan(i)
            // Right subtree has (n-i-1) nodes -> Catalan(n-i-1)
            ans += CN(i) * CN(n - i - 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 4;

        // Catalan(4) = 14
        System.out.println(CN(n));
    }
}

/*
Time Complexity:
- Exponential (very slow)
  because it recomputes same subproblems multiple times

Approximately:
- O(2^n) (commonly written)
More accurate growth:
- related to Catalan numbers (~ 4^n / (n^(3/2)))

Space Complexity:
- O(n)
  due to recursion
*/ 