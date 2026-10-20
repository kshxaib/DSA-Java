
import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] pse = findPSE(heights);
        int[] nse = findNSE(heights);

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    private int[] findPSE(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] pse = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() &&
                   heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return pse;
    }

    private int[] findNSE(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] nse = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() &&
                   heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return nse;
    }
}
