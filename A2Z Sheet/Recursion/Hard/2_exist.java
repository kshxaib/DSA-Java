/*
        WORD SEARCH (BACKTRACKING ON GRID)

Definition:
Given a 2D board of characters and a word,
return true if the word exists in the grid.

Rules:
• Letters must be adjacent (up, down, left, right)
• Same cell cannot be used more than once
• Must match characters in order


Example

Board:
A B C E
S F C S
A D E E

Word = "ABCCED" → true


Core Idea (DFS + Backtracking)

We try to start from every cell,
and perform DFS to match the word.

At each step:
• Match current character
• Explore 4 directions
• Mark cell as visited
• Backtrack after exploration


Important Detail
You used:
board[i][j] = '#'

This prevents revisiting same cell.

Without this:
you may reuse same cell → WRONG


Time Complexity: O(n * m * 4^L)
Where:
n = rows
m = cols
L = length of word

Each cell explores 4 directions recursively

Space Complexity: O(L)
Recursion stack depth = length of word
*/

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