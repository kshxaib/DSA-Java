class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();

        // Existing count of 1's
        int activeCount = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                activeCount++;
            }
        }

        List<Integer> inactiveBlocks = new ArrayList<>();

        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '0') {
                int start = i;

                while (i < n && s.charAt(i) == '0') {
                    i++;
                }

                inactiveBlocks.add(i - start);
            } else {
                i++;
            }
        }

        int maxPairSum = 0;

        // max(inactiveBlocks[i] + inactiveBlocks[i-1])
        for (i = 1; i < inactiveBlocks.size(); i++) {
            maxPairSum = Math.max(maxPairSum, inactiveBlocks.get(i) + inactiveBlocks.get(i - 1));
        }

        return maxPairSum + activeCount;
    }
}