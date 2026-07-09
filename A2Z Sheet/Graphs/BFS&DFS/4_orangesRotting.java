import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new java.util.LinkedList<>();

        int fresh = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int minutes = 0;

        int dRow[] = {-1, 0, 1, 0};
        int dCol[] = {0, 1, 0, -1};

        while(!queue.isEmpty() && fresh > 0){
            int size = queue.size();

            for(int i=0; i<size; i++){
                int cell[] = queue.poll();
                int row = cell[0];
                int col = cell[1];

                for(int k=0; k<4; k++){
                    int newRow = row + dRow[k];
                    int newCol = col + dCol[k];

                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                       grid[newRow][newCol] == 1){

                        grid[newRow][newCol] = 2;
                        fresh--;

                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}