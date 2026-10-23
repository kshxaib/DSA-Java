class WordDictionary {
    class TrieNode{
        TrieNode children[];
        boolean isEnd;

        public TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;

        for(char ch : word.toCharArray()){
            int index = ch - 'a';

            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.isEnd = true;        
    }
    
    public boolean search(String word){
        return searchUtil(root, word);
    }

    public boolean searchUtil(TrieNode root, String word) {
        TrieNode curr = root;

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(ch == '.'){
                for(int j=0; j<26; j++){

                    if(curr.children[j] != null){
                        if(searchUtil(curr.children[j], word.substring(i+1))){
                            return true;
                        }
                    }
                }

                return false;
            }

            int index = ch - 'a';

            if(curr.children[index] == null){
                return false;
            }

            curr = curr.children[index];
        }

        return curr.isEnd;
    }
}
