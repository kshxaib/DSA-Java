class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;

        boolean visited[][] = new boolean[n][m];
        int maxArea = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if(grid[i][j] == 1 && !visited[i][j]){
                    int area = dfs(grid, visited, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int grid[][], boolean visited[][], int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0 || visited[row][col]){
            return 0;
        }

        int count = 0;
        if(grid[row][col] == 1){
            count++;
            visited[row][col] = true;
        }

        count += dfs(grid, visited, row -1, col);
        count += dfs(grid, visited, row +1, col);
        count += dfs(grid, visited, row, col -1);
        count += dfs(grid, visited, row, col +1);

        return count;
    }
}