public class LC_242 {

    // Checks whether two strings are anagrams
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public boolean isAnagram(String s, String t) {

        // If lengths are different, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Frequency array for 26 lowercase English letters
        int freq[] = new int[26];

        // Increase frequency for characters in s
        // Decrease frequency for characters in t
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        // If any frequency is not zero, strings are not anagrams
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }

        // All frequencies matched
        return true;
    }
}
