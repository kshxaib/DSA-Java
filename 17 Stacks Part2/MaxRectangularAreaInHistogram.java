import java.util.*;

// Problem: Maximum Rectangular Area in Histogram
/*
📌 Problem Statement:
Given an array representing the heights of histogram bars,
find the **largest rectangular area** that can be formed in the histogram.

Example:
Input  → [2, 1, 5, 6, 2, 3]
Output → 10  
(The largest rectangle is formed by heights 5 and 6 → width = 2, area = 5×2 = 10)

---

👉 Concept:
- For each bar, find how far it can extend **left and right**
  until a smaller bar blocks it.
- To do this efficiently, use:
   1️⃣ Next Smaller to Right (NSR)
   2️⃣ Next Smaller to Left (NSL)
- The **width** of each rectangle = NSR[i] - NSL[i] - 1
- Area = height[i] × width
- Track the maximum area found.
*/

public class MaxRectangularAreaInHistogram {

    // 🔹 Function to calculate the largest area in the histogram
    public static void maxArea(int heights[]) {
        int n = heights.length;
        int maxArea = 0;
        int nextSmallerRight[] = new int[n];
        int nextSmallerLeft[] = new int[n];

        // ============================================================
        // Step 1️⃣ → Find Next Smaller to Right (NSR) for each bar
        // ============================================================
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

        // ============================================================
        // Step 2️⃣ → Find Next Smaller to Left (NSL) for each bar
        // ============================================================
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

        // ============================================================
        // Step 3️⃣ → Calculate area for each bar using:
        // width = NSR[i] - NSL[i] - 1
        // area = height[i] × width
        // ============================================================
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int width = nextSmallerRight[i] - nextSmallerLeft[i] - 1;
            int area = height * width;

            maxArea = Math.max(maxArea, area);
        }

        // 🔹 Print the maximum rectangular area
        System.out.println("Max area in histogram is: " + maxArea);
    }

    // ============================================================
    // Step 4️⃣ → Driver Code
    // ============================================================
    public static void main(String[] args) {
        int heights[] = {2, 1, 5, 6, 2, 3};

        // Expected output: 10
        maxArea(heights);
    }
}

/*
📌 Dry Run Example:
Input: [2, 1, 5, 6, 2, 3]

For height 5:
   NSL = 1 (index of smaller 1)
   NSR = 4 (index of smaller 2)
   Width = 4 - 1 - 1 = 2
   Area = 5 × 2 = 10 ✅

Max Area = 10

---

📊 Time Complexity: O(n)
   Each element is pushed and popped at most once from the stack.

📊 Space Complexity: O(n)
   Used for stacks and NSL/NSR arrays.

✅ Concept Used:
Monotonic Stack (used to find nearest smaller elements efficiently)
*/
