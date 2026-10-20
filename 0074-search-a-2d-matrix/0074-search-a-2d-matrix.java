class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = n * m -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            int row = mid / m;
            int col = mid % m;

            int element = matrix[row][col];

            if(element == target){
                return true;
            } else if(element < target){
                low = mid +1;
            } else {
                high = mid -1;
            }
        }

        return false;
    }
}

// Time: O(n * logn)
// Space: O(1)