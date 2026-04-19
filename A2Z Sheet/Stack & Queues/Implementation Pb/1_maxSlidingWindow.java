/*
        SLIDING WINDOW MAXIMUM

Definition:
Given an array nums[] and window size k,

Move a window of size k from left to right,
return maximum element of each window.


Example

Input:
nums = [1,3,-1,-3,5,3,6,7]
k = 3

Windows:

[1,3,-1] → 3
[3,-1,-3] → 3
[-1,-3,5] → 5
[-3,5,3] → 5
[5,3,6] → 6
[3,6,7] → 7

Output:
[3,3,5,5,6,7]


Core Idea (MONOTONIC DEQUE)

Use deque storing INDICES.
Maintain elements in decreasing order.
Front always stores maximum index.


Why This Works

Deque stores only useful candidates:
• Smaller elements behind bigger ones are useless and removed.
• Expired indices outside window removed.


Time Complexity: O(n)
Each index added once, removed once.

Space Complexity: O(k)
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int ans[] = new int[n - k + 1];

        // first window
        for(int i = 0; i < k; i++){
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
        }

        ans[0] = nums[deque.peekFirst()];

        // remaining windows
        for(int i = k; i < n; i++){
            // remove expired index
            if(deque.peekFirst() <= i - k){
                deque.removeFirst();
            }

            // remove smaller elements
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);

            // max of current window
            ans[i - k + 1] = nums[deque.peekFirst()];
        }

        return ans;
    }
}