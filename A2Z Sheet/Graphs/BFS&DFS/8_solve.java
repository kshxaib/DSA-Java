class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        // first and last row
        for(int j=0; j<m; j++){
            if(board[0][j] == 'O'){
                dfs(0, j, board);
            } 

            if(board[n-1][j] == 'O'){
                dfs(n-1, j, board);
            }
        }

        // first and last column
        for(int i=0; i<n; i++){
            if(board[i][0] == 'O'){
                dfs(i, 0, board);
            }

            if(board[i][m-1] == 'O'){
                dfs(i, m-1, board);
            }
        }

        // convert the non visited 'O's to 'X's
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int row, int col, char board[][]){
        board[row][col] = '#'; // mark visited and cannot be converted to 'X'

        int dRow[] = {-1, 0, 1, 0};
        int dCol[] = {0, 1, 0, -1};

        for(int i=0; i<4; i++){
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];


            if(newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length &&
               board[newRow][newCol] == 'O'){

                dfs(newRow, newCol, board);
            }
        }
    }
}