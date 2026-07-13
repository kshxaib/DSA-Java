class Solution {
    public int strStrBrute(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            while (j < m && haystack.charAt(i + j) == needle.charAt(j))  j++;

            if (j == m) return i;
        }

        return -1;
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        int[] lps = buildLPS(needle);   // Build LPS array for pattern

        int i = 0, j = 0;   // haystack pointer AND needle pointer

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {   // Characters match
                i++;
                j++;

                if (j == needle.length()) return i - j;      // Entire pattern matched
            } else {     // Mismatch after some matches

                if (j != 0) {
                    j = lps[j - 1];  // Jump using LPS
                } else {
                    i++;    // No prefix matched, move text pointer
                }
            }
        }

        return -1;
    }

    private int[] buildLPS(String pattern) {    // Build Longest Prefix Suffix (LPS) array
        int[] lps = new int[pattern.length()];

        int len = 0;     // Length of current matching prefix
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) { // Characters match
                len++;
                lps[i] = len;
                i++;
            } else {

                if (len != 0) { // Try smaller prefix
                    len = lps[len - 1];
                } else {     // No prefix exists
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}