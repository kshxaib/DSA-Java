/*
                SPIRAL MATRIX TRAVERSAL

Problem:
Given an m × n matrix, return all elements of the
matrix in spiral order.

Example:

Input:
[ [1,2,3],
  [4,5,6],
  [7,8,9] ]

Output:
[1,2,3,6,9,8,7,4,5]


Core Idea:
Traverse the matrix layer by layer while shrinking
the boundaries.

Maintain four boundaries:

startRow → top boundary
endRow   → bottom boundary
startCol → left boundary
endCol   → right boundary

At each layer, traverse:

1. Top row      → left → right
2. Right column → top → bottom
3. Bottom row   → right → left
4. Left column  → bottom → top

After completing a layer, move boundaries inward.


Algorithm Steps:
While startRow ≤ endRow AND startCol ≤ endCol:

1. Traverse top row
2. Traverse right column
3. Traverse bottom row (if more than one row)
4. Traverse left column (if more than one column)

Then shrink boundaries:

startRow++
endRow--
startCol++
endCol--


Complexities:
Time Complexity  : O(m × n)
Space Complexity : O(1)  (excluding output list)

Properties:
- Layer-by-layer traversal
- Boundary shrinking technique
- Works for both square and rectangular matrices

Key Interview Points:
- Use four boundaries
- Avoid duplicates with row/column checks
- Shrink boundaries after each layer
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        int startRow = 0;
        int endRow = n-1;
        int startCol = 0;
        int endCol = m-1;

        while(startRow<=endRow && startCol<=endCol){
            for(int j=startCol; j<=endCol; j++){
                ans.add(matrix[startRow][j]);
            }

            for(int i=startRow +1; i<=endRow; i++){
                ans.add(matrix[i][endCol]);
            }

            // Bottom row (only if more than one row)
            if (startRow < endRow) {
                for (int j = endCol - 1; j >= startCol; j--) {
                    ans.add(matrix[endRow][j]);
                }
            }

            // Left column (only if more than one column)
            if (startCol < endCol) {
                for (int i = endRow - 1; i > startRow; i--) {
                    ans.add(matrix[i][startCol]);
                }
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return ans;
    }
}

// Time: O(m * n)
// Space: O(1) (excluding output)