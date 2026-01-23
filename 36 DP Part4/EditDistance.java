public class EditDistance {

    /*
      Edit Distance (Levenshtein Distance) - Tabulation DP

      Meaning:
      - Find minimum number of operations to convert word1 -> word2

      Allowed operations:
      1) Insert  (add)
      2) Delete  (del)
      3) Replace (rep)

      dp[i][j] means:
      - minimum operations needed to convert:
        word1[0 ... i-1] into word2[0 ... j-1]
    */
    public static int ED(String w1, String w2) {

        int n = w1.length();
        int m = w2.length();

        // dp table size: (n+1) x (m+1)
        int dp[][] = new int[n + 1][m + 1];

        // Base case:
        // If word2 is empty, delete all characters of word1
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }

        // Base case:
        // If word1 is empty, insert all characters of word2
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }

        // Fill dp table
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                // If characters match, no operation needed
                if (w1.charAt(i - 1) == w2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];

                } else {
                    // If characters don't match, try all 3 operations

                    // Insert in word1 (move left)
                    int add = dp[i][j - 1] + 1;

                    // Delete from word1 (move up)
                    int del = dp[i - 1][j] + 1;

                    // Replace character (move diagonal)
                    int rep = dp[i - 1][j - 1] + 1;

                    // Take minimum operations
                    dp[i][j] = Math.min(add, Math.min(del, rep));
                }
            }
        }

        // Final answer stored at dp[n][m]
        return dp[n][m];
    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";

        System.out.println(ED(word1, word2)); // Output: 5
    }
}

/*
Time Complexity:
- O(n * m)

Space Complexity:
- O(n * m)
*/
