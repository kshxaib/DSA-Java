import java.util.*;

public int kDistinctChar(String s, int k) {
    int n = s.length();
    int maxLen = 0;

    int left = 0, right = 0;

    Map<Character, Integer> freq = new HashMap<>();

    while (right < n) {
        char ch = s.charAt(right);

        // include current char
        freq.put(ch, freq.getOrDefault(ch, 0) + 1);

        // shrink until valid
        while (freq.size() > k) {
            char leftChar = s.charAt(left);
            freq.put(leftChar, freq.get(leftChar) - 1);

            // remove if count becomes zero
            if (freq.get(leftChar) == 0) {
                freq.remove(leftChar);
            }

            left++;
        }

        // valid window length
        int len = right - left + 1;
        maxLen = Math.max(maxLen, len);

        right++;
    }

    return maxLen;
}