/*
        N-QUEENS PROBLEM (BACKTRACKING ON BOARD)

Definition:
Place n queens on an n x n chessboard
such that NO two queens attack each other.

A queen can attack:
• same row
• same column
• diagonals


Example

Input:
n = 4

Output:
[
 [".Q..","...Q","Q...","..Q."],
 ["..Q.","Q...","...Q",".Q.."]
]


Core Idea

We place queens COLUMN by COLUMN.

At each column:
→ try placing queen in every row
→ check if safe
→ recurse for next column
→ backtrack


Why Column-wise?
Because:
• each column must have exactly one queen
• avoids checking column again


Time Complexity: O(N!)
we try placing queens in permutations

Space Complexity
O(N^2) → board  
O(N) → recursion stack
*/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char board[][] = new char[n][n];

        // initialize board with '.'
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j] = '.';
            }
        }

        findNQueens(board, ans, 0);
        return ans;
    }

    public void findNQueens(char board[][], List<List<String>> ans, int col){

        // base case: all queens placed
        if(col == board.length){
            List<String> temp = new ArrayList<>();

            for(int i=0; i<board.length; i++){
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        // try placing queen in each row
        for(int row=0; row<board.length; row++){
            if(isSafe(board, row, col)){

                // place queen
                board[row][col] = 'Q';

                // move to next column
                findNQueens(board, ans, col + 1);

                // backtrack
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(char board[][], int row, int col){

        // check left row
        for(int j=0; j<col; j++){
            if(board[row][j] == 'Q') return false;
        }

        // check upper-left diagonal
        for(int i=row, j=col; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q') return false;
        }

        // check lower-left diagonal
        for(int i=row, j=col; i<board.length && j>=0; i++, j--){
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }
}