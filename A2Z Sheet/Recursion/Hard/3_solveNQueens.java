class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char board[][] = new char[n][n];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j] = '.';
            }
        }

        findNQueens(board, ans, 0);

        return ans;
    }

    public void findNQueens(char board[][], List<List<String>> ans, int col){
        if(col == board.length){
            List<String> temp = new ArrayList<>();
            for(int i=0; i<board.length; i++){
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        for(int row=0; row<board.length; row++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                findNQueens(board, ans, col +1);
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(char board[][], int row, int col){

        // left row
        for(int j=0; j<col; j++){
            if(board[row][j] == 'Q') return false;
        }

        // upper-left diagonal
        for(int i=row, j=col; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q') return false;
        }

        // lower-left diagonal
        for(int i=row, j=col; i<board.length && j>=0; i++, j--){
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }
}