class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean visited[][] = new boolean[n][m];
        int islands = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    islands++;

                    dfs(i, j, grid, visited);
                }
            }
        }

        return islands;
    }

    private void dfs(int row, int col, char[][] grid, boolean[][] visited){
        visited[row][col] = true;

        int dRow[] = {-1, 0, 1, 0}; 
        int dCol[] = {0, 1, 0, -1}; 

        for(int i=0; i<4; i++){
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

             if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length &&
                    grid[newRow][newCol] == '1' && !visited[newRow][newCol]){
               
                        dfs(newRow, newCol, grid, visited);
               }
        }
    }
}