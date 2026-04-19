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

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            // current bar smaller than previous bars
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                int element = heights[stack.pop()];
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();

                int area = element * (nse - pse - 1);
                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        // remaining bars
        while(!stack.isEmpty()){
            int element = heights[stack.pop()];
            int nse = n;
            int pse = stack.isEmpty() ? -1 : stack.peek();

            int area = element * (nse - pse - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}