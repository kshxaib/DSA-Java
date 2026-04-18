/*
        NEXT GREATER ELEMENT (RIGHT SIDE)

Definition:
Given an array,
for each element find the NEXT GREATER element
on its RIGHT.

If none exists → return -1


Example

Input:
arr = [4, 5, 2, 10]

Output:
[5, 10, 10, -1]


Example

Input:
arr = [3, 2, 1]

Output:
[-1, -1, -1]


Core Idea (MONOTONIC STACK)
We use a stack to maintain elements
in DECREASING order.

Why This Works
For each element:
we remove all smaller elements on the right
because they can NEVER be the next greater.


Time Complexity: O(n)
Each element is pushed and popped once

Space Complexity: O(n)
Stack in worst case
*/

class Solution {
    public int[] nextLargerElement(int[] arr) {
        int n = arr.length;
        int ans[] = new int [n];
        Stack<Integer> stack = new Stack<>();

        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        return ans;
    }
}