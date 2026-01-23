public class LCS {

    /*
      LCS (Recursive Approach)

      Meaning:
      - Find the length of the Longest Common Subsequence between str1 and str2
      - Subsequence means:
        characters must be in order, but not necessarily contiguous

      lcs(str1, str2, n, m) means:
      - LCS length between str1[0...n-1] and str2[0...m-1]
    */
    public static int lcs(String str1, String str2, int n, int m) {

        // Base case:
        // If any string becomes empty, LCS length = 0
        if (n == 0 || m == 0) {
            return 0;
        }

        // If last characters match
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {

            // Include this matching character in LCS
            // move both pointers back
            return lcs(str1, str2, n - 1, m - 1) + 1;
        }

        // If last characters do not match:
        // Try two possibilities:
        // 1) Remove last char from str1
        // 2) Remove last char from str2
        int ans1 = lcs(str1, str2, n - 1, m);
        int ans2 = lcs(str1, str2, n, m - 1);

        // Best of both options
        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {

        String str1 = "abcdge";
        String str2 = "abedg";

        System.out.println(lcs(str1, str2, str1.length(), str2.length()));
    }
}

/*
Time Complexity:
- O(2^(n+m)) approximately (exponential)
  because we branch into 2 calls for most mismatches

Space Complexity:
- O(n + m)
  due to recursion stack depth
*/
