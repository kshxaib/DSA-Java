import java.util.*;

class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int n = words.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLength = 1;

        for (int index = 0; index < n; index++) {
            for (int prevIndex = 0; prevIndex < index; prevIndex++) {

                if (isPredecessor(words[prevIndex], words[index]) && dp[prevIndex] + 1 > dp[index]) {
                    dp[index] = dp[prevIndex] + 1;
                }
            }

            maxLength = Math.max(maxLength, dp[index]);
        }

        return maxLength;
    }

    private boolean isPredecessor(String shorter, String longer) {
        if (longer.length() != shorter.length() + 1) return false;  // length must differ by exactly one

        int i = 0;
        int j = 0;

        while (i < shorter.length() && j < longer.length()) {
            if (shorter.charAt(i) == longer.charAt(j)) {    // matching character
                i++;
                j++;    
            } else {    // skip extra character
                j++;
            }
        }

        return i == shorter.length();   // all shorter characters matched
    }
}