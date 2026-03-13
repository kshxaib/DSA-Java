/*
        SEARCH IN A 2D MATRIX
           (BINARY SEARCH)

Problem:
Given a matrix where:

1. Each row is sorted in non-decreasing order.
2. The first element of a row is greater than
   the last element of the previous row.

Determine if a target value exists in the matrix.


Example 1
mat =
[
 [1,2,3,4],
 [5,6,7,8],
 [9,10,11,12]
]

target = 8

Output: true

Explanation:
8 exists at index (1,3).


Key Observation:
Because of the matrix property:
Last element of a row < First element of next row
The matrix behaves like a single sorted array.

Example:
Matrix:

[
 [1,2,3]
 [4,5,6]
 [7,8,9]
]

Equivalent array: [1,2,3,4,5,6,7,8,9]


Core Idea:
Treat the matrix as a 1D sorted array
of size: n * m

Then apply Binary Search.

Index Mapping Trick
Convert 1D index → 2D coordinates

row = index / number_of_columns
col = index % number_of_columns

Example:

m = 4
index = 6

row = 6 / 4 = 1
col = 6 % 4 = 2

So position = (1,2)

Complexities
Time Complexity  : O(log(n*m))
Space Complexity : O(1)
*/

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

// Time: O(log(n*m))
// Space: O(1)