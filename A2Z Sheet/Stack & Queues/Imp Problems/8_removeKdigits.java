/*
        REMOVE K DIGITS

Definition:
Given a non-negative integer num as string
and integer k,

Remove exactly k digits so that
the new number is the smallest possible.

Return result as string.


Example 1

Input:
num = "1432219"
k = 3

Output:
"1219"


Example 2

Input:
num = "10200"
k = 1

Output:
"200"


Example 3

Input:
num = "10"
k = 2

Output:
"0"


Core Idea (MONOTONIC INCREASING STACK)

To make smallest number:

Keep digits in increasing order.

If current digit is smaller than previous,
remove previous larger digit.


Why This Works
Earlier digits have higher place value.

Removing a larger digit earlier
reduces number more.


Time Complexity: O(n)
Each digit pushed/popped once

Space Complexity: O(n)
*/

class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < n; i++){

            char digit = num.charAt(i);

            // remove bigger previous digits
            while(!stack.isEmpty() && k > 0 && stack.peek() > digit){
                stack.pop();
                k--;
            }

            stack.push(digit);
        }

        // remove remaining digits from end
        while(k > 0){
            stack.pop();
            k--;
        }

        if(stack.isEmpty()) return "0";

        StringBuilder ans = new StringBuilder();

        // stack gives reverse order
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }

        // remove leading zeros of final answer
        while(ans.length() > 0 &&
              ans.charAt(ans.length() - 1) == '0') {

            ans.deleteCharAt(ans.length() - 1);
        }

        ans.reverse();

        if(ans.length() == 0) return "0";

        return ans.toString();
    }
}