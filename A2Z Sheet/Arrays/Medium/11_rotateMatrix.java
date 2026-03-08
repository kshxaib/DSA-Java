/*
            ROTATE MATRIX BY 90° CLOCKWISE

Problem:
Given an n × n matrix, rotate the matrix by 90 degrees
clockwise in-place.

Example:

Input:
[ [1,2,3],
  [4,5,6],
  [7,8,9] ]

Output:
[ [7,4,1],
  [8,5,2],
  [9,6,3] ]

Optimal Idea (In-place Rotation):
Rotate matrix in two steps:

1. Transpose the matrix
   (swap rows with columns)
2. Reverse each row


Step 1: Transpose
Convert matrix[i][j] → matrix[j][i]

Example:
Original:
1 2 3
4 5 6
7 8 9

Transpose:
1 4 7
2 5 8
3 6 9


Step 2: Reverse each row

1 4 7  → 7 4 1
2 5 8  → 8 5 2
3 6 9  → 9 6 3

Final result:
7 4 1
8 5 2
9 6 3


Algorithm Steps:
1. Traverse upper triangle of matrix
2. Swap matrix[i][j] with matrix[j][i]
3. Reverse every row


Complexities:
Time Complexity  : O(n²)
Space Complexity : O(1)

Properties:
- In-place matrix transformation
- No extra matrix required
- Works only for square matrices (n × n)

Key Interview Points:
- Transpose swaps rows and columns
- Row reversal completes clockwise rotation
- Classic matrix manipulation problem
*/

class Solution {
    public void rotateMatrix(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, i, j);
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            reverse(matrix, i, 0, n - 1);
        }
    }

    private void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    private void reverse(int[][] matrix, int row, int i, int j) {
        while (i < j) {
            int temp = matrix[row][i];
            matrix[row][i] = matrix[row][j];
            matrix[row][j] = temp;
            i++;
            j--;
        }
    }
}

// Time: O(n²)
// Space: O(1)