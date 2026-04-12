class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    public boolean solve(char board[][], int row, int col){
        if(row == 9){
            return true;
        }

        int nextRow = row;
        int nextCol = col +1;

        if(nextCol == 9){
            nextRow = row +1;
            nextCol = 0;
        }

        if(board[row][col] != '.'){
            return solve(board, nextRow, nextCol);
        }

        for(char i='1'; i<='9'; i++){
            if(isSafe(board, row, col, i)){
                board[row][col] = i;
                if(solve(board, nextRow, nextCol)){
                    return true;
                }

                board[row][col] = '.';
            }
        }

        return false;
    }

    public boolean isSafe(char board[][], int row, int col, char digit){
        // horizontal
        for(int j=0; j<9; j++){
            if(board[row][j] == digit){
                return false;
            }
        }

        // vertical
        for(int i=0; i<9; i++){
            if(board[i][col] == digit){
                return false;
            }
        }

        // check 3x3 subgrid
        int startingRow = (row / 3) * 3;
        int startingCol = (col / 3) * 3;
         for (int i = startingRow; i < startingRow + 3; i++) {
            for (int j = startingCol; j < startingCol + 3; j++) {
                if (board[i][j] == digit) {
                    return false; 
                }
            }
        }

        return true;
    }
}