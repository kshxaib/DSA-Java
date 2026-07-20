import java.util.*;

/**
 * Main
 */
class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int rows = mat.length;

        for (int i = 0; i < rows; i++) {
            if (binarySearch(mat[i], target)) {
                return true;
            }
        }

        return false;
    }

    private boolean binarySearch(int[] row, int target) {
        int start = 0;
        int end = row.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}