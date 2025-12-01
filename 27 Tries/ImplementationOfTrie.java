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


    //---------------Prefix Problem--------------------
    static class Node2{
        Node2 children [] = new Node2[26];
        boolean endOfWord = false;
        int freq;

        public Node2(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node2 root2 = new Node2();

    public static void insert2(String word){
        Node2 curr = root2;
        for(int lvl=0; lvl<word.length(); lvl++){
            int idx = word.charAt(lvl) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node2();
            } else{
                curr.children[idx].freq++;
            }

            curr = curr.children[idx];
        }

        curr.endOfWord = true;
    }

    public static void findPrefix(Node2 root2, String ans){
        if(root2 == null){
            return;
        }

        if(root2.freq == 1){
            System.out.println(ans);
            return;
        }

        for(int i=0; i<26; i++){
            if(root2.children[i] != null){
                findPrefix(root2.children[i], ans+(char)(i+'a'));
            }
        }
    }

    //----------- startsWith Problem ------------------------
    public static boolean startsWith(String prefix){    // O(L)
        Node curr = root;
        for(int i=0; i<prefix.length(); i++){
            int idx = prefix.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }

            curr = curr.children[idx];
        }

        return true;
    }

    //--------------- Count Unique Substring OR Nodes ---------------------
    public static int countUSubstring(Node root){
        if(root == null){
            return 0;
        }

        int count = 0;
        for(int i=0; i<26; i++){
            if(root.children[i] != null){
                count += countUSubstring(root.children[i]);
            }
        }

        return count +1;
    }

    public static void main(String[] args) {
        // Implementation of Trie
        // String words[] = {"the", "a", "there", "their", "any", "thee"};
        // for(int i=0; i<words.length; i++){
        //     insert(words[i]);
        // }
        // System.out.println(search("their"));

        // Word Breaking Problem
        // String arr[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        // for(int i=0; i<arr.length; i++){
        //     insert(arr[i]);
        // }
        // String key = "ilikesamsung";
        // System.out.println(wordBreak(key));

        // Prefix Problem
        // String arr[] = {"zebra", "dog", "duck", "dove"};
        // for(int i=0; i<arr.length; i++){
        //      insert(arr[i]);
        // }
        // root2.freq = -1;
        // findPrefix(root2, "");

        // startsWith Problem
        // String words[] = {"apple", "app", "mango", "man", "woman"};
        // String prefix1 = "app";
        // String prefix2 = "moon";
        // for(int i=0; i<words.length; i++){
        //     insert(words[i]);
        // }
        // System.out.println(startsWith(prefix1));

        // Count Unique Substring
        String str = "ababa";
        // suffix -> insert in trie
        for(int i=0; i<str.length(); i++){
            insert(str.substring(i));
        }
        System.out.println(countUSubstring(root));
    }
}