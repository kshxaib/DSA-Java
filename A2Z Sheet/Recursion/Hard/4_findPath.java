/*
        RAT IN A MAZE (BACKTRACKING ON GRID)

Definition:
Given an n x n grid,
a rat starts at (0,0) and wants to reach (n-1,n-1).

Rules:
• 1 → open cell (can move)
• 0 → blocked cell (cannot move)
• Allowed moves:
  U (up), D (down), L (left), R (right)
• Cannot visit same cell twice

Return ALL possible paths.


Example

Input:
grid =
[ [1,0,0,0],
  [1,1,0,1],
  [1,1,0,0],
  [0,1,1,1] ]

Output:
["DDRDRR", "DRDDRR"]


Core Idea

This is a BACKTRACKING + DFS problem.
At each cell:
→ try all 4 directions
→ mark visited
→ explore
→ backtrack


Why This Works

We explore all possible paths,
but avoid:
• blocked cells
• revisiting same cell


Time Complexity: O(4^(n*n)) (worst case)
Because each cell explores 4 directions


Space Complexity: O(n^2) → visited array  
O(path length) → recursion stack  
*/

class Solution {
    public List<String> findPath(int[][] grid) {
        int n = grid.length;
        List<String> ans = new ArrayList<>();
        int[][] visited = new int[n][n];

        // start or end blocked
        if (grid[0][0] == 0 || grid[n-1][n-1] == 0) return ans;

        visited[0][0] = 1;

        solve(0, 0, grid, ans, "", visited, n);

        return ans;
    }

    public void solve(int i, int j, int[][] grid, List<String> ans, String path, int[][] visited, int n) {

        // base case: destination reached
        if (i == n - 1 && j == n - 1) {
            ans.add(path);
            return;
        }

        // Down
        if (i + 1 < n && visited[i + 1][j] == 0 && grid[i + 1][j] == 1) {
            visited[i + 1][j] = 1;
            solve(i + 1, j, grid, ans, path + "D", visited, n);
            visited[i + 1][j] = 0; // backtrack
        }

        // Left
        if (j - 1 >= 0 && visited[i][j - 1] == 0 && grid[i][j - 1] == 1) {
            visited[i][j - 1] = 1;
            solve(i, j - 1, grid, ans, path + "L", visited, n);
            visited[i][j - 1] = 0; // backtrack
        }

        // Right
        if (j + 1 < n && visited[i][j + 1] == 0 && grid[i][j + 1] == 1) {
            visited[i][j + 1] = 1;
            solve(i, j + 1, grid, ans, path + "R", visited, n);
            visited[i][j + 1] = 0; // backtrack
        }

        // Up
        if (i - 1 >= 0 && visited[i - 1][j] == 0 && grid[i - 1][j] == 1) {
            visited[i - 1][j] = 1;
            solve(i - 1, j, grid, ans, path + "U", visited, n);
            visited[i - 1][j] = 0; // backtrack
        }
    }
}