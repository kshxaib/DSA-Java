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

        if (i == n - 1 && j == n - 1) {
            ans.add(path);
            return;
        }

        // Down
        if (i + 1 < n && visited[i + 1][j] == 0 && grid[i + 1][j] == 1) {
            visited[i + 1][j] = 1;
            solve(i + 1, j, grid, ans, path + "D", visited, n);
            visited[i + 1][j] = 0;
        }

        // Left
        if (j - 1 >= 0 && visited[i][j - 1] == 0 && grid[i][j - 1] == 1) {
            visited[i][j - 1] = 1;
            solve(i, j - 1, grid, ans, path + "L", visited, n);
            visited[i][j - 1] = 0;
        }

        // Right
        if (j + 1 < n && visited[i][j + 1] == 0 && grid[i][j + 1] == 1) {
            visited[i][j + 1] = 1;
            solve(i, j + 1, grid, ans, path + "R", visited, n);
            visited[i][j + 1] = 0;
        }

        // Up
        if (i - 1 >= 0 && visited[i - 1][j] == 0 && grid[i - 1][j] == 1) {
            visited[i - 1][j] = 1;
            solve(i - 1, j, grid, ans, path + "U", visited, n);
            visited[i - 1][j] = 0;
        }
    }
}