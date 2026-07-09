class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // first and last row
        for(int j=0; j<m; j++){
            if(grid[0][j] == 1){
                dfs(0, j, grid);
            }

            if(grid[n-1][j] == 1){
                dfs(n-1, j, grid);
            }
        }

        // first and last column
        for(int i=0; i<n; i++){
            if(grid[i][0] == 1){
                dfs(i, 0, grid);
            }

            if(grid[i][m-1] == 1){
                dfs(i, m-1, grid);
            }
        }

        int count = 0;
        // count remaining land
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    count++;
                }

                // restore
                else if(grid[i][j] == -1){
                    grid[i][j] = 1;
                }
            }
        }

        return count;
    }

    private void dfs(int row, int col, int[][] grid){
        grid[row][col] = -1; // visited / safe land

        int dRow[] = {-1,0,1,0};
        int dCol[] = {0,1,0,-1};

        for(int i=0; i<4; i++){
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length &&
               grid[newRow][newCol] == 1){

                dfs(newRow, newCol, grid);
            }
        }
    }
}