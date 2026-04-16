/*
        VALID PARENTHESES (STACK)

Definition:
Given a string s containing only:
'(', ')', '{', '}', '[' and ']',

Return true if the string is valid.

A string is valid if:
• Every opening bracket has a matching closing bracket
• Brackets are closed in the correct order
• Proper nesting is maintained


Example 1

Input:
s = "()"

Output:
true


Example 2

Input:
s = "()[]{}"

Output:
true


Example 3

Input:
s = "(]"

Output:
false


Example 4

Input:
s = "([)]"

Output:
false


Core Idea (STACK)
Use a stack to track opening brackets.

Rule:
• Push opening brackets
• For closing bracket → check top of stack


Why This Works
Stack follows LIFO:
Last opened → first to be closed


Time Complexity: O(n)

Space Complexity: O(n)
(stack in worst case)
*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // handling closing brackets
            else {
                if (stack.isEmpty()) return false;

                char top = stack.peek();

                if ((ch == ')' && top == '(') ||
                    (ch == '}' && top == '{') ||
                    (ch == ']' && top == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}