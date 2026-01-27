class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length -1;

        while(row < matrix.length && col >= 0){
            int element = matrix[row][col];
            if(element == target){
                return true;
            } else if(element > target){
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
}

// Time: O(n * logn)
// Space: O(1)