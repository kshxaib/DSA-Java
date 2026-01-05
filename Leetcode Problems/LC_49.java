import java.util.*;

public class LC_49 {
    // Groups strings that are anagrams of each other
    // Time Complexity: O(n * k)
    // Space Complexity: O(n * k)
    public List<List<String>> groupAnagrams(String[] strs) {

        // Edge case: empty input
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        // Map to store anagram groups
        // Key   -> frequency pattern of characters
        // Value -> list of strings with same pattern
        Map<String, List<String>> map = new HashMap<>();

        // Frequency array for 26 lowercase English letters
        int[] count = new int[26];

        // Traverse each string in the input
        for (String s : strs) {

            // Reset frequency array for current string
            Arrays.fill(count, 0);

            // Count frequency of each character
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Build a unique key using character frequencies
            // Example: "#1#0#2#0..."
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }

            String key = sb.toString();

            // If key not present, create a new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add current string to its anagram group
            map.get(key).add(s);
        }

        // Return all grouped anagrams
        return new ArrayList<>(map.values());
    }
}