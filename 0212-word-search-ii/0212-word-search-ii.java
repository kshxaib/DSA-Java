class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;

        List<String> ans = new ArrayList<>();

        for(String word : words){
            insert(word);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int index = board[i][j] - 'a';

                if(root.children[index] != null){
                    TrieNode curr = root;
                    findWord(board, i, j, curr, ans);
                }
            }
        }

        return ans;
    }

    public void findWord(char board[][], int i, int j, TrieNode curr, List<String> ans){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return;
        }

        if(board[i][j] == '#' || curr.children[board[i][j] - 'a'] == null){
            return;
        }

        curr = curr.children[board[i][j] - 'a'];

        if(curr.isEnd == true){
            ans.add(curr.word);
            curr.isEnd = false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        findWord(board, i + 1, j, curr, ans);
        findWord(board, i - 1, j, curr, ans);
        findWord(board, i, j + 1, curr, ans);
        findWord(board, i, j - 1, curr, ans);

        board[i][j] = temp;
    }

    class TrieNode{
        TrieNode children[];
        boolean isEnd;
        String word;

        TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
            word = "";
        }
    }

    TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode curr = root;

        for(char ch : word.toCharArray()){
            int index = ch - 'a';

            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.word = word;
        curr.isEnd = true;
    }
}