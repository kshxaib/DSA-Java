/*
                SET MATRIX ZEROES

Problem:
Given an m × n matrix, if any element is 0, set its
entire row and column to 0.

The modification must be done in-place.

Example:
matrix =
[1 1 1
 1 0 1
 1 1 1]

Output:
[1 0 1
 0 0 0
 1 0 1]


Optimal Idea (O(1) Space Trick):
Use the first row and first column as markers.

When we encounter a zero at (i, j):

- Mark row by setting matrix[i][0] = 0
- Mark column by setting matrix[0][j] = 0

But there is a problem:
matrix[0][0] cannot represent both first row
and first column.

So we use a separate variable:

col0 → tracks whether column 0 should be zero.


Algorithm Steps:

1. Traverse the matrix.
   If matrix[i][j] == 0:
       mark matrix[i][0] = 0
       mark matrix[0][j] = 0

2. Traverse the matrix again (excluding first row/col):
       if matrix[i][0] == 0 OR matrix[0][j] == 0
              set matrix[i][j] = 0

3. Handle first row separately:
       if matrix[0][0] == 0 → set entire row 0 to 0

4. Handle first column separately:
       if col0 == 0 → set entire column 0 to 0


Complexities:
Time Complexity  : O(n × m)
Space Complexity : O(1)

Properties:
- In-place modification
- Uses matrix itself for markers
- No extra arrays required

Key Interview Points:
- First row and column act as markers
- Special variable needed for column 0
- Classic matrix optimization problem
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int col0 = 1;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    
                    if(j != 0){
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int j=0; j<m; j++){
                matrix[0][j] = 0;
            }
        }

        if(col0 == 0){
            for(int i=0; i<n; i++){
                matrix[i][0] = 0;
            }
        }
    }
}

// Time: O(n * m)
// Space: O(1)