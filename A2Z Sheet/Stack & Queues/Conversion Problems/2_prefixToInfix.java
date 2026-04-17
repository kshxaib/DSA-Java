/*
        PREFIX TO INFIX (STACK)

Definition:
Convert a PREFIX expression into INFIX expression.

Prefix:
Operator comes BEFORE operands

Example:
+AB  → (A+B)


Example

Input:
*+AB-CD

Output:
((A+B)*(C-D))


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
    public String prefixToInfix(String s) {
        Stack<String> stack = new Stack<>();

        // traverse from right to left
        for(int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);

            // operand
            if(Character.isLetterOrDigit(ch)){
                stack.push(ch + "");
            }
            // operator
            else{
                String op1 = stack.pop();
                String op2 = stack.pop();

                String expr = "(" + op1 + ch + op2 + ")";
                stack.push(expr);
            }
        }

        return stack.peek();
    }
}