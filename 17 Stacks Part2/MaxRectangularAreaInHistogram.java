import java.util.*;

// Problem: Maximum Rectangular Area in Histogram

public class MaxRectangularAreaInHistogram {

    public static void maxArea(int heights[]) {
        int n = heights.length;
        int maxArea = 0;
        int nextSmallerRight[] = new int[n];
        int nextSmallerLeft[] = new int[n];

        // Step 1: Find Next Smaller to Right (NSR) for each bar
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Pop until we find a smaller element to the right
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }

            // If stack empty → no smaller element on right → boundary = n
            if (stack.isEmpty()) {
                nextSmallerRight[i] = n;
            } else {
                // Stack top gives index of next smaller element
                nextSmallerRight[i] = stack.peek();
            }

            // Push current index to stack
            stack.push(i);
        }

        // Step 2: Find Next Smaller to Left (NSL) for each bar
        stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop until we find a smaller element to the left
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }

            // If stack empty → no smaller element on left → boundary = -1
            if (stack.isEmpty()) {
                nextSmallerLeft[i] = -1;
            } else {
                // Stack top gives index of next smaller element
                nextSmallerLeft[i] = stack.peek();
            }

            // Push current index to stack
            stack.push(i);
        }

        // Step 3: Calculate area for each bar using:
        // width = NSR[i] - NSL[i] - 1
        // area = height[i] × width
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int width = nextSmallerRight[i] - nextSmallerLeft[i] - 1;
            int area = height * width;

            maxArea = Math.max(maxArea, area);
        }

        // Print the maximum rectangular area
        System.out.println("Max area in histogram is: " + maxArea);
    }

    public static void main(String[] args) {
        int heights[] = {2, 1, 5, 6, 2, 3};

        maxArea(heights);
    }
}

/*
📊 Time Complexity: O(n)
   Each element is pushed and popped at most once from the stack.

📊 Space Complexity: O(n)
   Used for stacks and NSL/NSR arrays.
*/
