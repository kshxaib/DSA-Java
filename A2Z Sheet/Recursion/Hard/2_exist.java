class Solution {

    public boolean search(char[][] board, String word, int n, int m, int i, int j, int k) {

        if (k == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= n || j >= m || board[i][j] != word.charAt(k)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#'; // mark visited

        boolean down = search(board, word, n, m, i + 1, j, k + 1);
        boolean up = search(board, word, n, m, i - 1, j, k + 1);
        boolean right = search(board, word, n, m, i, j + 1, k + 1);
        boolean left = search(board, word, n, m, i, j - 1, k + 1);

        board[i][j] = temp; // restore

        return down || up || right || left;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(board, word, n, m, i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}