/*
        NEXT SMALLER ELEMENT (RIGHT SIDE)

Definition:
For every element in array,
find the next smaller element on RIGHT side.

If no smaller element exists → return -1


Example

Input:
arr = [4, 8, 5, 2, 25]

Output:
[2, 5, 2, -1, -1]

Explanation:

4 → next smaller = 2  
8 → next smaller = 5  
5 → next smaller = 2  
2 → none  
25 → none


Core Idea (MONOTONIC INCREASING STACK)
Traverse from RIGHT → LEFT

Maintain stack such that:
top gives nearest smaller candidate.


Why This Works

Any element greater than or equal to current
can never be next smaller for current or left elements.

So remove them.


Time Complexity: O(n)
Each element pushed + popped once

Space Complexity: O(n)
*/

class Solution {
    public int[] nextSmallerElements(int[] arr) {
        int n = arr.length;

        int ans[] = new int[n];

        Stack<Integer> stack = new Stack<>();

        // traverse from right to left
        for(int i = n - 1; i >= 0; i--){

            // remove all greater or equal elements
            // because they cannot be next smaller
            while(!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }

            // if stack empty => no smaller element
            if(stack.isEmpty()) {
                ans[i] = -1;
            } 
            // top of stack = next smaller
            else {
                ans[i] = stack.peek();
            }

            // push current element for future left elements
            stack.push(arr[i]);
        }

        return ans;
    }
}