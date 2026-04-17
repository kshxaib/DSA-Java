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