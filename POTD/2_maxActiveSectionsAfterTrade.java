import java.util.*;

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();

        // Count existing active ('1') sections.
        int activeCount = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                activeCount++;
            }
        }

        // Store the length of every consecutive block of '0's.
        List<Integer> inactiveBlocks = new ArrayList<>();

        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '0') {
                int start = i;

                // Traverse the entire current 0-block.
                while (i < n && s.charAt(i) == '0') {
                    i++;
                }

                // Length of current inactive block.
                inactiveBlocks.add(i - start);
            } else {
                i++;
            }
        }

        int maxPairSum = 0;

        // Best trade merges two adjacent 0-blocks
        // separated by exactly one 1-block.
        for (i = 1; i < inactiveBlocks.size(); i++) {
            maxPairSum = Math.max(maxPairSum,
                                  inactiveBlocks.get(i) + inactiveBlocks.get(i - 1));
        }

        // Existing 1's + maximum newly activated 0's.
        return activeCount + maxPairSum;
    }
}