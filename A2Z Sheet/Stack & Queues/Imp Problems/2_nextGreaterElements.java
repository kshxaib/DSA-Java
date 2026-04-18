/*
        NEXT GREATER ELEMENT II (CIRCULAR ARRAY)

Definition:
Given a CIRCULAR array nums,
for every element find the next greater element.

If no greater element exists → return -1

Circular means:
after last index, search continues from start.


Example 1

Input:
nums = [1,2,1]

Output:
[2,-1,2]

Explanation:

For index 0 → next greater of 1 = 2  
For index 1 → no greater than 2 → -1  
For index 2 → wrap around, next greater of 1 = 2


Example 2

Input:
nums = [5,4,3,2,1]

Output:
[-1,5,5,5,5]


Core Idea (MONOTONIC STACK + DOUBLE TRAVERSAL)
Since array is circular:
Traverse array TWICE from right to left.


Why This Works
Normal next greater uses right-side values.

Circular array also needs left-side values
(after wrap-around).

Traversing 2*n handles that.

Time Complexity: O(n)
Each element pushed/popped at most twice

Space Complexity: O(n)
*/


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 2 * n - 1; i >= 0; i--){
            int idx = i % n;

            while(!stack.isEmpty() && stack.peek() <= nums[idx]){
                stack.pop();
            }

            if(stack.isEmpty() && i < n){
                ans[i] = -1;
            }
            else if(!stack.isEmpty() && i < n){
                ans[i] = stack.peek();
            }

            stack.push(nums[idx]);
        }

        return ans;
    }
}