class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;

        int start = 0;
        int end = n * m - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            int row = mid / m;
            int col = mid % m;

            if(mat[row][col] == target){
                return true;
            }
            else if(mat[row][col] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return false;
    }
}


Search in a 2D matrix
Subscribe to TUF+

Hints
Company
Given a 2-D array mat where the elements of each row are sorted in non-decreasing order, and the first element of a row is greater than the last element of the previous row (if it exists), and an integer target, determine if the target exists in the given mat or not.


Example 1

Input: mat = [ [1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12] ], target = 8

Output: True

Explanation: The target = 8 exists in the 'mat' at index (1, 3).

Example 2

Input: mat = [ [1, 2, 4], [6, 7, 8], [9, 10, 34] ], target = 78

Output: False

Explanation: The target = 78 does not exist in the 'mat'. Therefore in the output, we see 'false'.in
give notes