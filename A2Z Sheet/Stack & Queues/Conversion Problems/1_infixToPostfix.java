/*
        INFIX TO POSTFIX (STACK + OPERATOR PRECEDENCE)

Definition:
Convert an INFIX expression to POSTFIX.

Infix:
A + B

Postfix:
AB+


Example

Input:
A + B * C

Output:
ABC*+


Input:
(A + B) * C

Output:
AB+C*


Core Idea
Use STACK to handle operators
based on precedence and brackets.


Why This Works
• Operands → directly added to result
• Operators → handled using stack
• Parentheses → control evaluation order


Operator Precedence
^  → 3 (highest)
* / → 2
+ - → 1


Time Complexity: O(n)

Space Complexity: O(n)
*/

import java.util.*;

class Solution {
    public String infixToPostfix(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // operand
            if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')){
                ans.append(ch);
            }

            // opening bracket
            else if (ch == '(') {
                stack.push(ch);
            }

            // closing bracket
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    ans.append(stack.pop());
                }
                stack.pop(); // remove '('
            }

            // operator
            else {
                while (!stack.isEmpty() &&
                       ((ch != '^' && precedence(ch) <= precedence(stack.peek())) ||
                        (ch == '^' && precedence(ch) < precedence(stack.peek())))) {
                    ans.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // remaining operators
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.toString();
    }

    private int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return -1;
    }
}