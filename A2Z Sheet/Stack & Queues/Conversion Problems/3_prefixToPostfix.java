/*
        PREFIX TO POSTFIX (STACK)

Definition:
Convert a PREFIX expression into POSTFIX.

Prefix:
Operator comes BEFORE operands

Postfix:
Operands come BEFORE operator


Example

Input:
*+AB-CD

Output:
AB+CD-*


Core Idea
Traverse the string from RIGHT → LEFT
Use a STACK of STRINGS


Why This Works

Prefix format:
Operator → Operand1 → Operand2

When scanning from right:
• operands come first
• operator combines them


Time Complexity: O(n)

Space Complexity: O(n)
*/

class Solution {
    public String prefixToPostfix(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            // operand
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            } 
            // operator
            else {
                String op1 = stack.pop();  
                String op2 = stack.pop();  

                String expr = op1 + op2 + ch;
                stack.push(expr);
            }
        }

        return stack.peek();
    }
}