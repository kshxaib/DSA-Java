import java.util.*;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        // Reduce unnecessary full rotations
        k %= total;

        // Rotate right using reversal algorithm
        reverse(grid, 0, total - 1, n);
        reverse(grid, 0, k - 1, n);
        reverse(grid, k, total - 1, n);

        // Convert grid to List<List<Integer>>
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(grid[i][j]);
            }

            ans.add(row);
        }

        return ans;
    }

    private void reverse(int[][] grid, int left, int right, int cols) {
        // Reverse elements by treating 2D grid as a 1D array
        while (left < right) {

            // Convert 1D index -> 2D coordinates
            int r1 = left / cols;
            int c1 = left % cols;

            int r2 = right / cols;
            int c2 = right % cols;

            // Swap elements
            int temp = grid[r1][c1];
            grid[r1][c1] = grid[r2][c2];
            grid[r2][c2] = temp;

            left++;
            right--;
        }
    }
}