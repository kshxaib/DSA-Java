import java.util.*;

class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    class Trie {
        TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode current = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';

                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }

                current = current.children[index];
            }

            current.isEnd = true;
        }

        public boolean checkAllPrefixes(String word) {
            TrieNode current = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';

                if (current.children[index] == null) {
                    return false;
                }

                current = current.children[index];

                // Every prefix must be a complete word
                if (!current.isEnd) {
                    return false;
                }
            }

            return true;
        }
    }

    public String completeString(List<String> nums) {
        Trie trie = new Trie();

        // Insert all words
        for (String word : nums) {
            trie.insert(word);
        }

        String ans = "";

        for (String word : nums) {

            if (trie.checkAllPrefixes(word)) {

                if (word.length() > ans.length()) {
                    ans = word;
                }
                else if (word.length() == ans.length() && word.compareTo(ans) < 0) {
                    ans = word;
                }
            }
        }

        return ans.equals("") ? "None" : ans;
    }
}