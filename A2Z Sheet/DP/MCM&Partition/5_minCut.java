import java.util.*;

class Solution1 {
    public int minCut(String s) {
        int n = s.length();

        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return solve(0, s, dp) - 1;
    }

    private int solve(int index, String s, int[] dp) {
        if (index == s.length()) return 0;

        if (dp[index] != -1) return dp[index];

        int minCuts = Integer.MAX_VALUE;

        for (int j = index; j < s.length(); j++) {

            if (isPalindrome(index, j, s)) {
                int cuts = 1 + solve(j + 1, s, dp);
                minCuts = Math.min(minCuts, cuts);
            }
        }

        return dp[index] = minCuts;
    }

    private boolean isPalindrome(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}




class Solution2 {
    public int minCut(String s) {
        int n = s.length();

        int[] dp = new int[n + 1];
        dp[n] = 0;

        for (int index = n - 1; index >= 0; index--) {
            int minCuts = Integer.MAX_VALUE;

            for (int j = index; j < n; j++) {

                if (isPalindrome(index, j, s)) {
                    int cuts = 1 + dp[j + 1];
                    minCuts = Math.min(minCuts, cuts);
                }
            }

            dp[index] = minCuts;
        }

        return dp[0] - 1;
    }

    private boolean isPalindrome(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}