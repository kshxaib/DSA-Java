import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;   // start or destination blocked

        Queue<int[]> queue = new LinkedList<>();    // stores matrix cells
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;   // distance from source

        //          Top-Left  Top  Top-Right  Left  Right  Bottom-Left  Bottom  Bottom-Right
        int dRow[] = {-1,      -1,    -1,      0,     0,       1,         1,         1};
        int dCol[] = {-1,       0,      1,     -1,     1,      -1,         0,         1};

        while(!queue.isEmpty()){
            int cell[] = queue.poll();
            int row = cell[0];
            int col = cell[1];

            int distance = grid[row][col];

            if(row == n-1 && col == n-1) return distance;   // destination reached

            for(int i=0; i<8; i++){      // explore all neighbours
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                // valid unvisited cell
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0){
                    grid[newRow][newCol] = distance + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return -1;
    }
}