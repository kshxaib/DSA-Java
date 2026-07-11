import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        // effort[row][col] = minimum effort needed to reach this cell
        int effort[][] = new int[n][m];

        for(int i=0; i<n; i++){
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }

        effort[0][0] = 0;   // source effort is 0

        // {current effort, row, col} always process cell having minimum effort first
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        pq.offer(new int[]{0, 0, 0});

        // 4 directions
        int dRow[] = {-1, 0, 1, 0};
        int dCol[] = {0, 1, 0, -1};

        while(!pq.isEmpty()){
            int cell[] = pq.poll();
            int currEffort = cell[0];
            int row = cell[1];
            int col = cell[2];

            // first time destination is removed from PQ, it has minimum possible effort
            if(row == n-1 && col == m-1){
                return currEffort;
            }

            for(int i=0; i<4; i++){     // explore all neighbours
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m){
                    // effort of moving to neighbour
                    int heightDifference = Math.abs(heights[row][col] - heights[newRow][newCol]);
                    // Path effort is NOT sum. It is the maximum edge difference seen so far in the path.
                    int newEffort = Math.max(currEffort, heightDifference);

                    // if this path gives smaller effort, update and process again
                    if(newEffort < effort[newRow][newCol]){
                        effort[newRow][newCol] = newEffort;
                        pq.offer(new int[]{newEffort, newRow, newCol});
                    }
                }
            }
        }

        return 0;
    }
}