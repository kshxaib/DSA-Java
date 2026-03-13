/*
        SEARCH IN 2D MATRIX – II
         (TOP-RIGHT TRAVERSAL)

Problem:
Given a matrix where:
1. Each row is sorted in ascending order.
2. Each column is sorted in ascending order.

Determine if a target element exists in the matrix.

Example 
matrix =
[
 [1, 4, 7,11,15],
 [2, 5, 8,12,19],
 [3, 6, 9,16,22],
 [10,13,14,17,24],
 [18,21,23,26,30]
]

target = 5

Output: true

Explanation:
5 exists at position (1,1)


Key Observation
Rows are sorted → left → right
Columns are sorted → top → bottom

Example:
1   4   7  11
2   5   8  12
3   6   9  16
10 13  14 17


Core Idea
Start from the TOP-RIGHT corner.

Why?
Because that element helps eliminate
either a row or a column.


Movement Logic
Current element = matrix[row][col]

If element == target
        return true

If element > target
        move LEFT (col--)

If element < target
        move DOWN (row++)


Why This Works

From top-right position:
Everything to the LEFT is smaller.
Everything BELOW is larger.

So each comparison eliminates
an entire row or column.


Complexities
Time Complexity  : O(n + m)
Worst case traversal:
n rows + m columns.

Space Complexity : O(1)
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int col = m - 1;

        while(row < n && col >= 0){

            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] > target){
                col--;
            }
            else{
                row++;
            }
        }

        return false;
    }
}

// Time: O(n + m)
// Space: O(1)