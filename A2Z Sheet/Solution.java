import java.util.*;

/**
 * Main
 */
class Solution {
    public int findMedian(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] arr = new int[n * m];

        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[idx++] = matrix[i][j];
            }
        }

        Arrays.sort(arr);

        return arr[(n * m) / 2];
    }
}