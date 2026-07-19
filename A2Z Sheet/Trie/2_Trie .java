

class Trie {
    class TrieNode {
        TrieNode[] children;
        int prefixCount; // Number of words passing through this node
        int endCount;    // Number of words ending at this node

        TrieNode() {
            children = new TrieNode[26];
            prefixCount = 0;
            endCount = 0;
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word
    public void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
            current.prefixCount++;
        }

        current.endCount++;
    }

    // Count exact occurrences of a word
    public int countWordsEqualTo(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                return 0;
            }

            current = current.children[index];
        }

        return current.endCount;
    }

    // Count words having given prefix
    public int countWordsStartingWith(String prefix) {
        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                return 0;
            }

            current = current.children[index];
        }

        return current.prefixCount;
    }

    // Erase one occurrence of a word
    public void erase(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            current = current.children[index];
            current.prefixCount--;
        }

        current.endCount--;
    }
}