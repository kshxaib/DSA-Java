/*
        SUDOKU SOLVER (BACKTRACKING ON GRID)

Definition:
Given a partially filled 9x9 Sudoku board,
fill the board so that:

• Each row contains digits 1–9 (no repetition)
• Each column contains digits 1–9
• Each 3x3 subgrid contains digits 1–9


Core Idea
This is a BACKTRACKING problem.

At each empty cell ('.'):
→ try digits from '1' to '9'
→ check if placement is valid
→ recurse
→ backtrack if needed


Time Complexity: O(9^(n*n)) worst case

Space Complexity: O(1)
Only recursion stack used
*/

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    public boolean solve(char board[][], int row, int col){

        // base case: reached end of board
        if(row == 9){
            return true;
        }

        int nextRow = row;
        int nextCol = col + 1;

        // move to next row if column ends
        if(nextCol == 9){
            nextRow = row + 1;
            nextCol = 0;
        }

        // skip filled cells
        if(board[row][col] != '.'){
            return solve(board, nextRow, nextCol);
        }

        // try digits 1 to 9
        for(char i = '1'; i <= '9'; i++){
            if(isSafe(board, row, col, i)){

                // place digit
                board[row][col] = i;

                // recurse
                if(solve(board, nextRow, nextCol)){
                    return true;
                }

                // backtrack
                board[row][col] = '.';
            }
        }

        return false;
    }

    public boolean isSafe(char board[][], int row, int col, char digit){

        // check row
        for(int j = 0; j < 9; j++){
            if(board[row][j] == digit){
                return false;
            }
        }

        // check column
        for(int i = 0; i < 9; i++){
            if(board[i][col] == digit){
                return false;
            }
        }

        // check 3x3 subgrid
        int startingRow = (row / 3) * 3;
        int startingCol = (col / 3) * 3;

        for(int i = startingRow; i < startingRow + 3; i++){
            for(int j = startingCol; j < startingCol + 3; j++){
                if(board[i][j] == digit){
                    return false;
                }
            }
        }

        return true;
    }
}