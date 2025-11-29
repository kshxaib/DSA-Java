public class ImplementationOfTrie{
    static class Node{
        Node children[] = new Node[26];
        boolean endOfWord = false;

        Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word){  // O(L) -> length of word
        Node curr = root;
        for(int lvl=0; lvl<word.length(); lvl++){
            int idx = word.charAt(lvl) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node(); 
            }
            curr = curr.children[idx];
        }

        curr.endOfWord = true;
    }

    public static boolean search(String word){  // O(L)
        Node curr = root;
        for(int lvl=0; lvl<word.length(); lvl++){
            int idx = word.charAt(lvl) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.endOfWord;
    }

    public static boolean wordBreak(String key) {   // O(L)
        if (key.length() == 0) {
            return true;
        }

        for (int i = 1; i <= key.length(); i++) {

            // key.substring(0, i) = prefix
            // key.substring(i)    = remaining suffix
            if (search(key.substring(0, i))     
                    && wordBreak(key.substring(i))) {  
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Implementation of Trie
        // String words[] = {"the", "a", "there", "their", "any", "thee"};
        // for(int i=0; i<words.length; i++){
        //     insert(words[i]);
        // }

        // System.out.println(search("their"));

        // Word Breaking Problem
        String arr[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        for(int i=0; i<arr.length; i++){
            insert(arr[i]);
        }
        String key = "ilikesamsung";
        System.out.println(wordBreak(key));
    }
}`