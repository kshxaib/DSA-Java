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


Time Complexity: O(N!) * O(N)
we try placing queens in permutations

Space Complexity
O(N^2) → board  
O(N) → recursion stack
*/
import java.util.*;

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
        if(col == board.length){     // base case: all queens placed
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

                board[row][col] = 'Q';  // place queen
                
                findNQueens(board, ans, col + 1);   // move to next column
                
                board[row][col] = '.';  // backtrack
            }
        }
    }

    public boolean isSafe(char board[][], int row, int col){
        for(int j=0; j<col; j++){   // check left row
            if(board[row][j] == 'Q') return false;
        }
        
        for(int i=row, j=col; i>=0 && j>=0; i--, j--){  // check upper-left diagonal
            if(board[i][j] == 'Q') return false;
        }
        
        for(int i=row, j=col; i<board.length && j>=0; i++, j--){    // check lower-left diagonal
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }
}