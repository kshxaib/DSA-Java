/*
         FIND PEAK ELEMENT – II
        (BINARY SEARCH ON COLUMNS)

Problem:
Given an n × m matrix where no two adjacent cells
are equal, find any peak element.

A peak element is strictly greater than its
four neighbours:

        top
        bottom
        left
        right

The matrix is surrounded by imaginary -1 values.

Return the position [row, col] of any peak.


Example 1
mat =
[
 [10,20,15],
 [21,30,14],
 [7 ,16,32]
]

Output:
[1,1]

Explanation:
30 is greater than:

20 (top)
21 (left)
14 (right)
16 (bottom)

So it is a peak.


Example 2
mat =
[
 [10,7],
 [11,17]
]

Output:
[1,1]

Explanation:
17 is greater than all neighbours.


Core Idea
Instead of searching every cell (O(n*m)),
we apply Binary Search on columns.


Observation
If we take a column and find the maximum
element in that column, that element
is the best candidate for a peak in that column.

Because:
All elements above and below it
are smaller.

So we only need to compare:
        left neighbour
        right neighbour


Binary Search Strategy
1. Pick middle column.
2. Find the maximum element in that column.
3. Compare with left and right neighbours.


Complexities
Time Complexity  : O(n log m)
Binary search → log m
Finding max in column → O(n)

Space Complexity : O(1)
*/

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat[0].length;

        int start = 0;
        int end = m - 1;

        while(start <= end){
            int midCol = start + (end - start) / 2;

            int maxIdx = findMax(mat, midCol);

            int maxEle = mat[maxIdx][midCol];

            int left = midCol - 1 >= 0 ? mat[maxIdx][midCol - 1] : -1;
            int right = midCol + 1 < m ? mat[maxIdx][midCol + 1] : -1;

            if(maxEle > left && maxEle > right){
                return new int[]{maxIdx, midCol};
            }
            else if(maxEle < left){
                end = midCol - 1;
            }
            else{
                start = midCol + 1;
            }
        }

        return new int[]{-1, -1};
    }

    public int findMax(int[][] mat, int col){
        int max = -1;
        int maxIdx = -1;

        for(int i = 0; i < mat.length; i++){
            if(mat[i][col] > max){
                max = mat[i][col];
                maxIdx = i;
            }
        }

        return maxIdx;
    }
}

// Time: O(n log m)
// Space: O(1)