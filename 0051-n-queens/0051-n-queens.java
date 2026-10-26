class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char board[][] = new char[n][n];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j] = '.';
            }
        }

        findNQueens(board, ans, 0, n);

        return ans;
    }

    public void findNQueens(char board[][], List<List<String>> ans, int row, int n){
        if(row == n){
            List<String> temp = new ArrayList<>();
            for(int i=0; i<board.length; i++){
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        for(int col = 0; col < board[0].length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                findNQueens(board, ans, row +1, n);
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(char board[][], int row, int col){
        for(int i = 0; i < row; i++){  
            if(board[i][col] == 'Q') return false;
        }
        
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){  // upper-left diagonal
            if(board[i][j] == 'Q') return false;
        }

        for(int i = row, j = col; i >= 0 && j < board[0].length; i--, j++){    // upper-right diagonal
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }
}