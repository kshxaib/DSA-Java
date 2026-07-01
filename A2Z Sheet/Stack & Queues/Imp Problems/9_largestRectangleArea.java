
/*
        LARGEST RECTANGLE IN HISTOGRAM

Definition:
Given an array heights[],
where each value represents bar height
(width of every bar = 1),

Find the area of the largest rectangle.


Example

Input:
heights = [2,1,5,6,2,3]

Output:
10

Explanation:

Largest rectangle:
height = 5
width = 2

Bars: [5,6]

Area = 5 * 2 = 10


Core Idea (MONOTONIC INCREASING STACK)

Maintain indices of bars in increasing height order.

Whenever current bar is smaller,
it means taller bars must stop here.

Then compute area immediately.


Why This Works

For a popped bar:
Current index i = Next Smaller Element (NSE)
New stack top = Previous Smaller Element (PSE)

Width: NSE - PSE - 1


Time Complexity: O(n)
Each index pushed/popped once

Space Complexity: O(n)
*/
import java.util.*;

class Solution {
    public int largestRectangleAreaBrute(int[] heights) {
        int maxArea = 0;

        // Loop through all possible start indices
        for (int i = 0; i < heights.length; i++) {
            int minHeight = Integer.MAX_VALUE;

            // Loop through all possible end indices
            for (int j = i; j < heights.length; j++) {
                // Update minimum height in current range
                minHeight = Math.min(minHeight, heights[j]);

                // Calculate area of current rectangle
                int area = minHeight * (j - i + 1);

                // Update maxArea
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        // Monotonic increasing stack (stores indices).
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Current bar is smaller, so rectangles end here.
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {   
                int height = heights[stack.pop()];  // Height of rectangle.

                int nse = i;    // Current index is Next Smaller Element.
                int pse = stack.isEmpty() ? -1 : stack.peek();  // Stack top is Previous Smaller Element.

                int width = nse - pse - 1;  // Width of rectangle.
                int area = height * width;  // Calculate area.

                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);  // Push current index.
        }

        // Process remaining bars.
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];

            int nse = n;    // No smaller element on the right.
            int pse = stack.isEmpty() ? -1 : stack.peek();

            int width = nse - pse - 1;
            int area = height * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}