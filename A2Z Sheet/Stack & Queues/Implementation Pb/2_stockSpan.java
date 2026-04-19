/*
        STOCK SPAN PROBLEM

Definition:
For each day i,
find span = number of consecutive days
(before or including today)

such that price <= today's price.


Example

Input:
arr = [100, 80, 60, 70, 60, 75, 85]

Output:
[1,1,1,2,1,4,6]


Explanation
Day 0 → 100
Span = 1


Day 3 → 70
Previous prices:
60 <= 70 ✔
80 > 70 stop
Span = 2


Day 6 → 85
Previous prices:
75 <= 85
60 <= 85
70 <= 85
60 <= 85
80 <= 85
100 > 85 stop

Span = 6


Core Idea (MONOTONIC STACK)

Use stack storing indices
with GREATER prices.

For each day:
Remove smaller/equal prices.
Top then becomes nearest previous greater price.


Why This Works
All smaller/equal previous prices
are included in span,
so they are useless after processing.


Time Complexity: O(n)
Each index pushed once, popped once.

Space Complexity: O(n)
*/

class Solution {
    public int[] stockSpan(int[] arr, int n) {

        int ans[] = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){

            // remove smaller/equal previous prices
            while(!stack.isEmpty() &&
                  arr[stack.peek()] <= arr[i]){

                stack.pop();
            }

            // no previous greater
            if(stack.isEmpty()){
                ans[i] = i + 1;
            }
            // previous greater exists
            else{
                ans[i] = i - stack.peek();
            }

            // push current day index
            stack.push(i);
        }

        return ans;
    }
}