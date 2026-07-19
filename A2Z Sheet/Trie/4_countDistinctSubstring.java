class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
    }

    public int countDistinctSubstring(String s) {
        TrieNode root = new TrieNode();
        int count = 0;

        // Insert all suffixes
        for (int i = 0; i < s.length(); i++) {

            TrieNode current = root;

            for (int j = i; j < s.length(); j++) {

                int index = s.charAt(j) - 'a';

                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                    count++; // New distinct substring found
                }

                current = current.children[index];
            }
        }

        // +1 for the empty substring
        return count + 1;
    }
}