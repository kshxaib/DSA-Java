import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int prefixSum[][] = new int[n][m];
        int maxArea = 0;

        for(int col=0; col<m; col++){
            int sum = 0;
            for(int i=0; i<n; i++){
                if(matrix[i][col] == '1'){
                    sum++;
                } else {
                    sum = 0;
                }

                prefixSum[i][col] = sum;
            }
        }

        for(int row=0; row<n; row++){
            // helper function will return the largest rectangle from that row
            int area = findlargestRectangleArea(prefixSum[row]);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public int findlargestRectangleArea(int heights[]){
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                int element = heights[stack.pop()];
                int nse = i;
                int pse = stack.peek();

                int area = element * (nse - pse -1);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);

        }
        while(!stack.isEmpty()) {
            int element = heights[stack.pop()];
            int nse = n;
            int pse = stack.isEmpty() ? -1 : stack.peek();

            int area = element * (nse - pse -1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}