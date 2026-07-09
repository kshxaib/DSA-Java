import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> queue = new java.util.LinkedList<>();
        boolean visited[][] = new boolean[n][m];

        int ans[][] = new int[n][m];

        // add all 0's as starting points
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int dRow[] = {-1, 0, 1, 0};
        int dCol[] = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            int cell[] = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for(int i=0; i<4; i++){
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                 if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol]){
                    ans[newRow][newCol] = ans[row][col] + 1; // Neighbour is one step away from current cell
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return ans;
    }
}