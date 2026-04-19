/*
        MAXIMAL RECTANGLE (BINARY MATRIX)

Definition:
Given a binary matrix containing:

'1' = filled cell
'0' = empty cell

Find the area of the largest rectangle
containing only 1's.


Example

Input:

[
 ['1','0','1','0','0'],
 ['1','0','1','1','1'],
 ['1','1','1','1','1'],
 ['1','0','0','1','0']
]

Output:
6


Largest Rectangle:

1 1 1
1 1 1

Area = 6


Core Idea

Convert each row into a HISTOGRAM.

Then for every row:

Find largest rectangle in histogram.


Why This Works

If consecutive 1’s continue vertically,
height increases.

So each row represents histogram heights.


Your Approach
You compute vertical prefix heights:

prefixSum[row][col] =
continuous 1's count ending at that row.

Then for each row:

Run Largest Rectangle in Histogram.


Time Complexity
Building heights: O(n * m)
Histogram each row: O(n * m)
Total: O(n * m)

Space Complexity: O(n * m)
O(n * m) for prefixSum
O(m) stack
*/


class Solution {

    public int maximalRectangle(char[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        // stores histogram heights for each row
        int prefixSum[][] = new int[n][m];
        int maxArea = 0;

        // build vertical heights
        for(int col = 0; col < m; col++){
            int sum = 0;

            for(int i = 0; i < n; i++){
                if(matrix[i][col] == '1'){
                    sum++;
                } else {
                    sum = 0;
                }

                prefixSum[i][col] = sum;
            }
        }

        // run histogram on every row
        for(int row = 0; row < n; row++){
            int area = findlargestRectangleArea(prefixSum[row]);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    // largest rectangle in histogram
    public int findlargestRectangleArea(int heights[]){
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){

            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                int element = heights[stack.pop()];
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();

                int area = element * (nse - pse - 1);
                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int element = heights[stack.pop()];
            int nse = n;
            int pse = stack.isEmpty() ? -1 : stack.peek();

            int area = element * (nse - pse - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}