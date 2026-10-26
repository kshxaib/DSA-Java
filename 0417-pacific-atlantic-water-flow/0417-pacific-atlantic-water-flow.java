class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();

        // Pacific: top and left borders
        // Atlantic: bottom and right borders
        for(int i=0; i<n; i++){
            addCell(pQueue, pacific, i, 0);
            addCell(aQueue, atlantic, i, m -1);
        }

        for (int j=0; j<m; j++) {
            addCell(pQueue, pacific, 0, j);
            addCell(aQueue, atlantic, n - 1, j);
        }

        bfs(heights, pQueue, pacific);
        bfs(heights, aQueue, atlantic);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void addCell(Queue<int[]> queue, boolean[][] visited, int row, int col){
        if(!visited[row][col]){
            visited[row][col] = true;
            queue.offer(new int[]{row, col});
        }
    }

    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited){
        int n = heights.length;
        int m = heights[0].length;

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int k = 0; k < 4; k++) {
                int newRow = row + dRow[k];
                int newCol = col + dCol[k];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol] &&
                    heights[newRow][newCol] >= heights[row][col]) {

                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
} 