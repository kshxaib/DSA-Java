class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int startingRow = 0;
        int startingCol = col -1;

        while(startingRow < row && startingCol >= 0){
            int currElement = matrix[startingRow][startingCol];

            if(currElement == target){
                return true;
            } else if (currElement > target){
                startingCol--;
            } else {
                startingRow++;
            }
        }

        return false;
    }
}