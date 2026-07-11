import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int effort[][] = new int[n][m];

        for(int i=0; i<n; i++){
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }

        effort[0][0] = 0;

        // {effort, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        pq.offer(new int[]{0, 0, 0});

        int dRow[] = {-1, 0, 1, 0};
        int dCol[] = {0, 1, 0, -1};

        while(!pq.isEmpty()){
            int cell[] = pq.poll();
            int currEffort = cell[0];
            int row = cell[1];
            int col = cell[2];

            // destination reached
            if(row == n-1 && col == m-1){
                return currEffort;
            }

            // skip outdated entries
            if(currEffort > effort[row][col]){
                continue;
            }

            for(int i=0; i<4; i++){

                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                if(newRow >= 0 && newRow < n &&
                   newCol >= 0 && newCol < m){

                    int edgeWeight = Math.abs(
                        heights[row][col] - heights[newRow][newCol]
                    );

                    int newEffort = Math.max(currEffort, edgeWeight);

                    if(newEffort < effort[newRow][newCol]){

                        effort[newRow][newCol] = newEffort;

                        pq.offer(new int[]{
                            newEffort,
                            newRow,
                            newCol
                        });
                    }
                }
            }
        }

        return 0;
    }
}