

class Trie {
    class TrieNode {
        TrieNode[] children;     // links to next characters
        boolean isEnd;          // marks end of a complete word

        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    TrieNode root;  // root of trie

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word
    public void insert(String word) {   
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {  // create node if absent
                current.children[index] = new TrieNode();
            }

            current = current.children[index];  // move to next node
        }

        current.isEnd = true;    // mark complete word
    }

    // Search complete word
    public boolean search(String word) {    
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {  // path doesn't exist
                return false;
            }

            current = current.children[index];  // move to next node
        }

        return current.isEnd;   // word exists only if marked as end
    }

    // Check if prefix exists
    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {  // prefix path doesn't exist
                return false;
            }

            current = current.children[index];  // move to next node
        }

        return true;    // prefix found
    }
}
