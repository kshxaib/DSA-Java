class Solution {
    public void shortestDistance(int[][] matrix) {
        int n = matrix.length;
        // Replace -1 with infinity
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int) 1e9;
                }

                if (i == j) {    // distance to itself is 0
                    matrix[i][j] = 0;
                }
            }
        }

        // Floyd-Warshall (try every node as intermediate (via))
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // relaxation: shorter path through "via"
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                }
            }
        }

        // negative cycle detection
        for (int i = 0; i < n; i++) {
            if (matrix[i][i] < 0) {
                // Negative cycle exists
            }
        }

        // Convert infinity back to -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == (int) 1e9) {
                    matrix[i][j] = -1;
                }
            }
        }
    }
}
