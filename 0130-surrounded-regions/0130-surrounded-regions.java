class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int n = board.length;
        int m = board[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // First and last row
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                addCell(0, j, board, queue);
            }

            if (board[n - 1][j] == 'O') {
                addCell(n - 1, j, board, queue);
            }
        }

        // First and last column
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                addCell(i, 0, board, queue);
            }

            if (board[i][m - 1] == 'O') {
                addCell(i, m - 1, board, queue);
            }
        }

        // BFS from all boundary 'O's
        bfs(board, queue);

        // Convert remaining 'O's to 'X' and '#' back to 'O'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void addCell(int row, int col, char[][] board, Queue<int[]> queue) {
        board[row][col] = '#';
        queue.offer(new int[]{row, col});
    }

    private void bfs(char[][] board, Queue<int[]> queue) {
        int n = board.length;
        int m = board[0].length;

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int k = 0; k < 4; k++) {
                int newRow = row + dRow[k];
                int newCol = col + dCol[k];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && board[newRow][newCol] == 'O') {
                    // Mark before enqueueing to avoid duplicates
                    board[newRow][newCol] = '#';
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}